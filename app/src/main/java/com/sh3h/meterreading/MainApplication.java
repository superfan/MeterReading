package com.sh3h.meterreading;

import android.app.Application;
import android.content.Context;

import com.sh3h.datautil.data.local.config.ConfigHelper;
import com.sh3h.meterreading.injection.component.ApplicationComponent;
import com.sh3h.meterreading.injection.component.DaggerApplicationComponent;
import com.sh3h.meterreading.injection.module.ApplicationModule;
import com.sh3h.mobileutil.util.LogUtil;

import java.io.File;

import timber.log.Timber;

public class MainApplication extends Application {
    private ApplicationComponent mApplicationComponent;

    public MainApplication() {
        mApplicationComponent = null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

//        if (BuildConfig.DEBUG) {
//            Timber.plant(new Timber.DebugTree());
//            //Fabric.with(this, new Crashlytics());
//        }

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static MainApplication get(Context context) {
        return (MainApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
