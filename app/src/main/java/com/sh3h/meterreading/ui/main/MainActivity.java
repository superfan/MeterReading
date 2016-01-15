package com.sh3h.meterreading.ui.main;

import android.os.Bundle;

import com.sh3h.datautil.data.model.Ribot;
import com.sh3h.meterreading.R;
import com.sh3h.meterreading.ui.base.BaseActivity;
//import com.sh3h.meterreading.injection.component.ActivityComponent2;
//import com.sh3h.meterreading.injection.component.DaggerActivityComponent2;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView {
    @Inject
    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_main);

        mMainPresenter.attachView(this);
        //mMainPresenter.loadRibots();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mMainPresenter.detachView();
    }

    @Override
    public void showRibots(List<Ribot> ribots) {
//        mRibotsAdapter.setRibots(ribots);
//        mRibotsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {
//        DialogFactory.createGenericErrorDialog(this, getString(R.string.error_loading_ribots))
//                .show();
    }

    @Override
    public void showRibotsEmpty() {
//        mRibotsAdapter.setRibots(Collections.<Ribot>emptyList());
//        mRibotsAdapter.notifyDataSetChanged();
//        Toast.makeText(this, R.string.empty_ribots, Toast.LENGTH_LONG).show();
    }
}
