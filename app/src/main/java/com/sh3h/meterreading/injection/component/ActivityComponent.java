package com.sh3h.meterreading.injection.component;

import com.sh3h.meterreading.ui.login.LoginActivity;
import com.sh3h.meterreading.ui.main.MainActivity;
import com.sh3h.meterreading.injection.annotation.PerActivity;
import com.sh3h.meterreading.injection.module.ActivityModule;
import com.sh3h.meterreading.ui.welcome.WelcomeActivity;

import dagger.Component;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(WelcomeActivity mainActivity);
    void inject(LoginActivity loginActivity);
    void inject(MainActivity mainActivity);
}