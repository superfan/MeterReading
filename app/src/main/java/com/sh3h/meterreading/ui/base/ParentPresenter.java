package com.sh3h.meterreading.ui.base;


import com.sh3h.datautil.data.DataManager;
import com.sh3h.datautil.data.local.config.ConfigHelper;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class ParentPresenter<P extends MvpView> extends BasePresenter<P> {
    protected final DataManager mDataManager;
    protected final ConfigHelper mConfigHelper;
    protected CompositeSubscription mSubscription;

    public ParentPresenter(DataManager dataManager, ConfigHelper configHelper) {
        mDataManager = dataManager;
        mConfigHelper = configHelper;
        mSubscription = new CompositeSubscription();
    }

    @Override
    public void attachView(P mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        mSubscription.unsubscribe();
    }
}
