package com.sh3h.meterreading.ui.welcome;


import android.content.Context;

import com.sh3h.datautil.data.DataManager;
import com.sh3h.datautil.data.entity.DUDeviceInfo;
import com.sh3h.datautil.data.entity.DUDeviceResult;
import com.sh3h.datautil.data.local.config.ConfigHelper;
import com.sh3h.meterreading.ui.base.ParentPresenter;
import com.sh3h.meterreading.util.DeviceUtil;
import com.sh3h.mobileutil.util.LogUtil;
import com.sh3h.mobileutil.util.TextUtil;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class WelcomePresenter extends ParentPresenter<WelcomeMvpView> {
    private static final String TAG = "WelcomePresenter";
    private ConfigHelper mConfigHelper;

    @Inject
    public WelcomePresenter(DataManager dataManager, ConfigHelper configHelper) {
        super(dataManager);
        mConfigHelper = configHelper;
    }

    /**
     * initialize
     */
    public void init() {
        mSubscription.add(mDataManager.initConfigFiles()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Void>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.i(TAG, "---init onCompleted---");
                        getMvpView().onFinished(WelcomeMvpView.Operation.INIT);

                        mDataManager.initLogger();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.i(TAG, "---init onError---");
                        getMvpView().onError(WelcomeMvpView.Operation.INIT, e.getMessage());
                    }

                    @Override
                    public void onNext(Void aVoid) {
                        LogUtil.i(TAG, "---init onNext---");
                        getMvpView().showProgress(50);
                    }
                }));
    }

    /**
     * authorize
     * @param context application
     */
    public void authorize(Context context) {
        String key = mConfigHelper.getKey();
        if (TextUtil.isNullOrEmpty(key)) {
            key = "";
        }

        String deviceId = DeviceUtil.getDeviceID(context);
        String macAddress = DeviceUtil.getMacAddress();
        if (TextUtil.isNullOrEmpty(deviceId) || TextUtil.isNullOrEmpty(macAddress)) {
            getMvpView().onError(WelcomeMvpView.Operation.AUTHORIZE, "deviceId or macAddress is error!!!");
            getMvpView().onFinished(WelcomeMvpView.Operation.AUTHORIZE);
            return;
        }

        DUDeviceInfo duDeviceInfo = new DUDeviceInfo(deviceId, macAddress, key);
        mSubscription.add(mDataManager.authorize(duDeviceInfo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<DUDeviceResult>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.i(TAG, "---authorize onCompleted---");
                        getMvpView().onFinished(WelcomeMvpView.Operation.AUTHORIZE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.i(TAG, "---authorize onError---");
                        getMvpView().onError(WelcomeMvpView.Operation.AUTHORIZE, e.getMessage());
                    }

                    @Override
                    public void onNext(DUDeviceResult duDeviceResult) {
                        LogUtil.i(TAG, "---authorize onNext---");
                        getMvpView().showProgress(100);
                        String key = duDeviceResult.getCode();
                        if (!TextUtil.isNullOrEmpty(key)) {
                            mConfigHelper.setKey(key);
                        }
                    }
                }));
    }
}
