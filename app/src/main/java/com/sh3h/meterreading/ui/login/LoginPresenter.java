package com.sh3h.meterreading.ui.login;


import com.sh3h.datautil.data.DataManager;
import com.sh3h.datautil.data.entity.DULoginInfo;
import com.sh3h.datautil.data.entity.DULoginResult;
import com.sh3h.datautil.data.entity.DUUserInfo;
import com.sh3h.datautil.data.entity.DUUserResult;
import com.sh3h.datautil.data.local.config.ConfigHelper;
import com.sh3h.datautil.data.local.preference.PreferencesHelper;
import com.sh3h.datautil.data.local.preference.UserSession;
import com.sh3h.meterreading.ui.base.ParentPresenter;
import com.sh3h.mobileutil.util.LogUtil;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class LoginPresenter extends ParentPresenter<LoginMvpView> {
    private static final String TAG = "LoginPresenter";
    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public LoginPresenter(DataManager dataManager,
                          PreferencesHelper preferencesHelper) {
        super(dataManager);
        mPreferencesHelper = preferencesHelper;
    }

    public void init() {
        UserSession userSession = mPreferencesHelper.getUserSession();
        userSession.readSharedPreferences();
        getMvpView().updateUserInfo(userSession.getAccount(), userSession.get_password());
    }

    public void login(String account, String password) {
        DULoginInfo duLoginInfo = new DULoginInfo(account, password);
        mSubscription.add(mDataManager.login(duLoginInfo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Boolean>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.i(TAG, "---login onCompleted---");
                        getMvpView().onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.i(TAG, String.format("---login onError: %s---", e.getMessage()));
                        getMvpView().onError(e.getMessage());
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        LogUtil.i(TAG, String.format("---login onNext: %s---", aBoolean ? "true" : "false"));
                    }
                }));
    }
}
