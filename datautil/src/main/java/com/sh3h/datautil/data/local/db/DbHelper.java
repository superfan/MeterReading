package com.sh3h.datautil.data.local.db;

import android.content.Context;

import com.sh3h.dataprovider.DBManager;
import com.sh3h.datautil.data.local.config.ConfigHelper;
import com.sh3h.datautil.injection.annotation.ApplicationContext;
import com.sh3h.mobileutil.util.LogUtil;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DbHelper {
    private final Context mContext;
    private final ConfigHelper mConfigHelper;

    @Inject
    public DbHelper(@ApplicationContext Context context,
                    ConfigHelper configHelper) {
        mContext = context;
        mConfigHelper = configHelper;
        //init();
    }

    /**
     * initialize
     */
    public void init() {
        //DBManager.getInstance().init(mConfigHelper.getDbPath(), mContext);
    }

    /**
     * destroy
     */
    public void destroy() {
        DBManager.getInstance().destroy();
    }
}
