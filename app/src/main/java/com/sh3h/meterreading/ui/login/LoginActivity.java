package com.sh3h.meterreading.ui.login;


import android.content.Intent;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sh3h.meterreading.R;
import com.sh3h.meterreading.ui.base.BaseActivity;
import com.sh3h.meterreading.ui.main.MainActivity;
import com.sh3h.mobileutil.util.ApplicationsUtil;
import com.sh3h.mobileutil.util.TextUtil;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


public class LoginActivity extends BaseActivity
        implements LoginMvpView, View.OnClickListener {
    @Inject
    LoginPresenter mLoginPresenter;

    @Bind(R.id.et_username)
    EditText mUserNameEditText;

    @Bind(R.id.et_password)
    EditText mPasswordEditText;

    @Bind(R.id.btn_submit)
    Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);

        mSubmitButton.setOnClickListener(this);

        mLoginPresenter.attachView(this);
        mLoginPresenter.init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mLoginPresenter.detachView();
    }

    @Override
    public void onClick(View v) {
        String account = mUserNameEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();
        if (TextUtil.isNullOrEmpty(account)) {
            ApplicationsUtil.showMessage(this, R.string.text_username_not_null);
            return;
        }

        if (TextUtil.isNullOrEmpty(password)) {
            ApplicationsUtil.showMessage(this, R.string.text_password_not_null);
            return;
        }

        mLoginPresenter.login(account, password);
    }

    @Override
    public void updateUserInfo(String account, String password) {
        if ((!TextUtil.isNullOrEmpty(account)) && (!TextUtil.isNullOrEmpty(password))) {
            mUserNameEditText.setText(account);
            mUserNameEditText.setSelection(account.length());
            mPasswordEditText.setText(password);
        }
    }

    @Override
    public void onCompleted() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onError(String message) {
        if (!TextUtil.isNullOrEmpty(message)) {
            ApplicationsUtil.showMessage(this, message);
        }
    }
}
