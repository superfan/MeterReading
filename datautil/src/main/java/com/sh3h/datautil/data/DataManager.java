package com.sh3h.datautil.data;

import com.sh3h.datautil.data.entity.DUDeviceResult;
import com.sh3h.datautil.data.entity.DULoginInfo;
import com.sh3h.datautil.data.entity.DULoginResult;
import com.sh3h.datautil.data.local.config.ConfigHelper;
import com.sh3h.datautil.data.local.config.KeyConfig;
import com.sh3h.datautil.data.local.db.DbHelper;
import com.sh3h.datautil.data.local.preference.PreferencesHelper;
import com.sh3h.datautil.data.entity.DUDeviceInfo;
import com.sh3h.datautil.data.remote.HttpHelper;
import com.sh3h.datautil.util.EventPosterHelper;
import com.sh3h.mobileutil.util.LogUtil;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class DataManager {
    private final HttpHelper mHttpHelper;
//    private final DatabaseHelper mDatabaseHelper;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ConfigHelper mConfigHelper;
    private final EventPosterHelper mEventPoster;

    @Inject
    public DataManager(HttpHelper httpHelper,
                       PreferencesHelper preferencesHelper,
                       DbHelper dbHelper,
                       ConfigHelper configHelper,
                       EventPosterHelper eventPosterHelper) {
        mHttpHelper = httpHelper;
        mPreferencesHelper = preferencesHelper;
        mDbHelper = dbHelper;
        mConfigHelper = configHelper;
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
    public Observable<DULoginResult> login(DULoginInfo duLoginInfo) {
        return mHttpHelper.login(duLoginInfo);
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

    /**
     * get the help of configure
     * @return
     */
    public ConfigHelper getConfigHelper() {
        return mConfigHelper;
    }
}
