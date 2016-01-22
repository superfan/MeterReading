package com.sh3h.meterreading.ui.main;

import android.content.Context;

import com.sh3h.datautil.data.DataManager;
import com.sh3h.datautil.data.entity.DUFileResult;
import com.sh3h.datautil.data.entity.DUTaskIdInfo;
import com.sh3h.datautil.data.entity.DUTaskIdResult;
import com.sh3h.datautil.data.entity.DUTaskInfo;
import com.sh3h.datautil.data.entity.DUTaskResult;
import com.sh3h.datautil.data.entity.DUUpdateInfo;
import com.sh3h.datautil.data.local.config.ConfigHelper;
import com.sh3h.datautil.data.local.config.VersionConfig;
import com.sh3h.datautil.data.local.preference.PreferencesHelper;
import com.sh3h.datautil.data.local.preference.UserSession;
import com.sh3h.datautil.data.model.Ribot;
import com.sh3h.meterreading.MainApplication;
import com.sh3h.meterreading.ui.base.BasePresenter;
import com.sh3h.meterreading.ui.base.ParentPresenter;
import com.sh3h.meterreading.util.DeviceUtil;
import com.sh3h.meterreading.util.SystemUtil;
import com.sh3h.mobileutil.util.LogUtil;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class MainPresenter extends ParentPresenter<MainMvpView> {
    private static final String TAG = "MainPresenter";
    private final ConfigHelper mConfigHelper;
    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public MainPresenter(DataManager dataManager,
                         ConfigHelper configHelper,
                         PreferencesHelper preferencesHelper) {
        super(dataManager);
        mConfigHelper = configHelper;
        mPreferencesHelper = preferencesHelper;
    }

//    public void init(Context context) {
//        int appVersion = SystemUtil.getVersionCode(MainApplication.get(context));
//        int dataVersion = mConfigHelper.getVersionConfig().getInteger(VersionConfig.DATA_VERSION, 1);
//        DUUpdateInfo duUpdateInfo = new DUUpdateInfo(appVersion, dataVersion);
//        mSubscription.add(mDataManager.updateVersion(duUpdateInfo)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<DUFileResult>() {
//                    @Override
//                    public void onCompleted() {
//                        LogUtil.i(TAG, "onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        LogUtil.i(TAG, "onError" + e.getMessage());
//                        //stopSelf(startId);
//                    }
//
//                    @Override
//                    public void onNext(DUFileResult duFileResult) {
//                        LogUtil.i(TAG, "onNext");
//                    }
//                }));
//    }

    public void test(Context context) {
//        UserSession userSession = mPreferencesHelper.getUserSession();
//        DUTaskIdInfo duTaskIdInfo = new DUTaskIdInfo(userSession.getAccount());
//        mDataManager.getTaskIds(duTaskIdInfo, false)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(new Subscriber<DUTaskIdResult>() {
//                @Override
//                public void onCompleted() {
//                    LogUtil.i(TAG, "onCompleted");
//                }
//
//                @Override
//                public void onError(Throwable e) {
//                    LogUtil.i(TAG, "onError" + e.getMessage());
//                }
//
//                @Override
//                public void onNext(DUTaskIdResult duTaskIdResult) {
//                    LogUtil.i(TAG, "onNext");
//                }
//            });

        UserSession userSession = mPreferencesHelper.getUserSession();
        DUTaskInfo duTaskInfo = new DUTaskInfo(
                userSession.getAccount(),
                2521,
                DeviceUtil.getDeviceID(context)
        );
        mDataManager.getTask(duTaskInfo, true)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DUTaskResult>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.i(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.i(TAG, "onError" + e.getMessage());
                    }

                    @Override
                    public void onNext(DUTaskResult duTaskResult) {
                        LogUtil.i(TAG, "onNext");
                    }
                });
    }

    public void destroy() {
        mDataManager.destroy();
    }

}
