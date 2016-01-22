package com.sh3h.meterreading.ui.login;


import com.sh3h.meterreading.ui.base.MvpView;

public interface LoginMvpView extends MvpView {
    void updateUserInfo(String account, String password);
    void onCompleted();
    void onError(String message);
}
