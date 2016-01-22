package com.sh3h.datautil.data;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.sh3h.datautil.data.entity.DUDeviceResult;
import com.sh3h.datautil.data.entity.DUFile;
import com.sh3h.datautil.data.entity.DUFileResult;
import com.sh3h.datautil.data.entity.DULoginInfo;
import com.sh3h.datautil.data.entity.DULoginResult;
import com.sh3h.datautil.data.entity.DUTask;
import com.sh3h.datautil.data.entity.DUTaskIdInfo;
import com.sh3h.datautil.data.entity.DUTaskIdResult;
import com.sh3h.datautil.data.entity.DUTaskInfo;
import com.sh3h.datautil.data.entity.DUTaskResult;
import com.sh3h.datautil.data.entity.DUUpdateInfo;
import com.sh3h.datautil.data.entity.DUUpdateResult;
import com.sh3h.datautil.data.entity.DUUserInfo;
import com.sh3h.datautil.data.entity.DUUserResult;
import com.sh3h.datautil.data.local.config.ConfigHelper;
import com.sh3h.datautil.data.local.config.KeyConfig;
import com.sh3h.datautil.data.local.db.DbHelper;
import com.sh3h.datautil.data.local.preference.PreferencesHelper;
import com.sh3h.datautil.data.entity.DUDeviceInfo;
import com.sh3h.datautil.data.local.preference.UserSession;
import com.sh3h.datautil.data.remote.Downloader;
import com.sh3h.datautil.data.remote.HttpHelper;
import com.sh3h.datautil.injection.annotation.ApplicationContext;
import com.sh3h.datautil.util.EventPosterHelper;
import com.sh3h.mobileutil.util.LogUtil;
import com.sh3h.mobileutil.util.TextUtil;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

@Singleton
public class DataManager {
    private final Context mContext;
    private final HttpHelper mHttpHelper;
//    private final DatabaseHelper mDatabaseHelper;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ConfigHelper mConfigHelper;
    private final EventPosterHelper mEventPoster;
    private final Downloader mDownloader;

    @Inject
    public DataManager(@ApplicationContext Context context,
                       HttpHelper httpHelper,
                       PreferencesHelper preferencesHelper,
                       DbHelper dbHelper,
                       ConfigHelper configHelper,
                       Downloader downloader,
                       EventPosterHelper eventPosterHelper) {
        mContext = context;
        mHttpHelper = httpHelper;
        mPreferencesHelper = preferencesHelper;
        mDbHelper = dbHelper;
        mConfigHelper = configHelper;
        mDownloader = downloader;
        mEventPoster = eventPosterHelper;
    }

    public void destroy() {
        mDbHelper.destroy();
    }

    /**
     * initialize configure files
     */
    public Observable<Void> initConfigFiles() {
        return mConfigHelper.initDefaultConfigs();
    }

    /**
     * authorize
     * @param duDeviceInfo device information
     * @return observable
     */
    public Observable<DUDeviceResult> authorize(DUDeviceInfo duDeviceInfo) {
        return mHttpHelper.authorize(duDeviceInfo);
    }

    /**
     * login
     * @param duLoginInfo
     * @return
     */
    public Observable<Boolean> login(final DULoginInfo duLoginInfo) {
        return mHttpHelper.login(duLoginInfo)
                .map(new Func1<DUUserResult, Boolean>() {
                    @Override
                    public Boolean call(DUUserResult duUserResult) {
                        UserSession userSession = mPreferencesHelper.getUserSession();
                        userSession.setAccount(duLoginInfo.getAccount());
                        userSession.set_password(duLoginInfo.getPassword());
                        userSession.setUserId(duUserResult.getUserId());
                        userSession.setUserName(duUserResult.getUserName());
                        return userSession.save();
                    }
                });
    }

    /**
     * update app or data
     * @param duUpdateInfo
     * @return
     */
    public Observable<DUFileResult> updateVersion(DUUpdateInfo duUpdateInfo) {
        return mHttpHelper.updateVersion(duUpdateInfo)
                .concatMap(new Func1<DUUpdateResult, Observable<DUFileResult>>() {
                    @Override
                    public Observable<DUFileResult> call(DUUpdateResult duUpdateResult) {
                        Observable<DUFileResult> observable =
                                mDownloader.downloadFile(duUpdateResult.getDuUpdateInfo(), duUpdateResult.getItemList());
                        if (observable == null) {
                            return Observable.create(new Observable.OnSubscribe<DUFileResult>() {
                                @Override
                                public void call(Subscriber<? super DUFileResult> subscriber) {
                                    subscriber.onError(new Throwable("downloadFile is failure"));
                                }
                            });
                        }

                        return observable;
                    }
                });
    }

//    public Observable<Void> downloadData(DUTaskIdInfo duTaskIdInfo) {
//        return mHttpHelper.getTaskIds(duTaskIdInfo);
//    }

    public Observable<DUTaskIdResult> getTaskIds(DUTaskIdInfo duTaskIdInfo, boolean isLocal) {
        if (isLocal) {
            return null;
        } else {
            return mHttpHelper.getTaskIds(duTaskIdInfo);
        }
    }

    public Observable<DUTaskResult> getTask(DUTaskInfo duTaskInfo, boolean isLocal) {
        if (isLocal) {
            return mDbHelper.getTask(duTaskInfo);
        } else {
            return mHttpHelper.getTask(duTaskInfo)
                    .doOnNext(new Action1<DUTaskResult>() {
                        @Override
                        public void call(DUTaskResult duTaskResult) {
                            mDbHelper.saveTask(duTaskResult);
                        }
                    });
        }
    }

    /**
     * initialize logger file
     */
    public void initLogger() {
        if (mConfigHelper != null) {
            File file = mConfigHelper.getLogFilePath();
            LogUtil.initLogger(file.getPath());
        }
    }


}
