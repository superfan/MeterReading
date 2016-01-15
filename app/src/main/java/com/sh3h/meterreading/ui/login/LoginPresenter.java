package com.sh3h.meterreading.ui.login;


import com.sh3h.datautil.data.DataManager;
import com.sh3h.datautil.data.entity.DULoginInfo;
import com.sh3h.datautil.data.entity.DULoginResult;
import com.sh3h.datautil.data.local.config.ConfigHelper;
import com.sh3h.meterreading.ui.base.ParentPresenter;
import com.sh3h.mobileutil.util.LogUtil;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginPresenter extends ParentPresenter<LoginMvpView> {
    private static final String TAG = "LoginPresenter";

    @Inject
    public LoginPresenter(DataManager dataManager, ConfigHelper configHelper) {
        super(dataManager, configHelper);
    }

    public void login(String account, String password) {
        DULoginInfo loginInfo = new DULoginInfo(account, password);
        mSubscription.add(mDataManager.login(loginInfo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<DULoginResult>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.i(TAG, "---login onCompleted---");

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.i(TAG, "---login onError---");

                    }

                    @Override
                    public void onNext(DULoginResult duLoginResult) {
                        LogUtil.i(TAG, "---login onNext---");

                    }
                }));
    }
}
