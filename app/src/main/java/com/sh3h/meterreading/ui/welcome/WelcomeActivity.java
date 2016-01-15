package com.sh3h.meterreading.ui.welcome;


import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sh3h.datautil.data.local.config.ConfigHelper;
import com.sh3h.datautil.data.model.Ribot;
import com.sh3h.meterreading.MainApplication;
import com.sh3h.meterreading.R;
import com.sh3h.meterreading.ui.base.BaseActivity;
import com.sh3h.meterreading.ui.login.LoginActivity;
import com.sh3h.meterreading.ui.main.MainActivity;
import com.sh3h.meterreading.ui.main.MainPresenter;
import com.sh3h.meterreading.util.SystemUtil;
import com.sh3h.mobileutil.util.ApplicationsUtil;
import com.sh3h.mobileutil.util.LogUtil;
import com.sh3h.mobileutil.util.TextUtil;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.sh3h.meterreading.ui.welcome.WelcomeMvpView.Operation;

public class WelcomeActivity extends BaseActivity implements WelcomeMvpView {
    @Inject
    WelcomePresenter mWelcomePresenter;

    @Bind(R.id.tv_state)
    TextView mStateTextView;

    @Bind(R.id.pb_loading)
    ProgressBar mProgressBar;

    @Bind(R.id.tv_version)
    TextView mVersionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);

        String version = SystemUtil.getVersionName(MainApplication.get(this));
        if (!TextUtil.isNullOrEmpty(version)) {
            mVersionTextView.setText(version);
        }

        mWelcomePresenter.attachView(this);
        mWelcomePresenter.init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mWelcomePresenter.detachView();
    }

    @Override
    public void showProgress(int length) {

    }

    @Override
    public void onError(Operation operation, String message) {
        if (!TextUtil.isNullOrEmpty(message)) {
            ApplicationsUtil.showMessage(this, message);
        }

        finish();
    }

    @Override
    public void onFinished(Operation operation) {
        switch (operation) {
            case INIT:
                authorize();
                break;
            case AUTHORIZE:
                jumpActivity();
                break;
        }
    }

    private void authorize() {
        mWelcomePresenter.authorize(MainApplication.get(this));
    }

    private void jumpActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
