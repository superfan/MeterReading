package com.sh3h.meterreading.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sh3h.datautil.data.model.Ribot;
import com.sh3h.meterreading.MainApplication;
import com.sh3h.meterreading.R;
import com.sh3h.meterreading.event.UIBusEvent;
import com.sh3h.meterreading.service.SyncService;
import com.sh3h.meterreading.service.VersionService;
import com.sh3h.meterreading.ui.base.BaseActivity;
import com.sh3h.meterreading.ui.base.ParentActivity;
import com.sh3h.meterreading.ui.task.TaskListActivity;
import com.squareup.okhttp.internal.Version;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
//import com.sh3h.meterreading.injection.component.ActivityComponent2;
//import com.sh3h.meterreading.injection.component.DaggerActivityComponent2;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends ParentActivity implements MainMvpView, View.OnClickListener {
    @Inject
    MainPresenter mMainPresenter;

    @Inject
    Bus mEventBus;

    @Bind(R.id.mytest1)
    Button mTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mTest.setOnClickListener(this);
        mMainPresenter.attachView(this);
        mEventBus.register(this);

        //startService(VersionService.getStartIntent(this));
        //startService(SyncService.getStartIntent(this));
        //mMainPresenter.init(this);
        mMainPresenter.test(MainApplication.get(this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mEventBus.unregister(this);
        mMainPresenter.detachView();

        //stopService(VersionService.getStartIntent(this));
        //stopService(SyncService.getStartIntent(this));

        System.exit(0);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.mytest1:
                Intent intent = new Intent(this, TaskListActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Subscribe
    public void onInstallingApk(UIBusEvent.InstallingApk installingApk) {
        finish();
    }
}
