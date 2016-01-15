package com.sh3h.datautil.data.local.preference;

import android.content.Context;
import android.content.SharedPreferences;


import com.sh3h.datautil.data.local.config.ConfigHelper;
import com.sh3h.datautil.injection.annotation.ApplicationContext;
import com.sh3h.mobileutil.util.LogUtil;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class PreferencesHelper {
    public static final String PREF_FILE_NAME = "android_boilerplate_pref_file";

    private final SharedPreferences mPref;
    private final ConfigHelper mConfigHelper;

    @Inject
    public PreferencesHelper(@ApplicationContext Context context,
                             ConfigHelper configHelper) {
        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        mConfigHelper = configHelper;
    }

    public void clear() {
        mPref.edit().clear().apply();
    }
}
