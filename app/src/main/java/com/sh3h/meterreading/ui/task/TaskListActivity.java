package com.sh3h.meterreading.ui.task;


import android.os.Bundle;

import com.sh3h.meterreading.R;
import com.sh3h.meterreading.ui.base.ParentActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class TaskListActivity extends ParentActivity implements TaskListMvpView {
    @Inject
    TaskListPresenter mTaskListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);

        mTaskListPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mTaskListPresenter.detachView();
    }
}
