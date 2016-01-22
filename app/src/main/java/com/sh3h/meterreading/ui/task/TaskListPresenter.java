package com.sh3h.meterreading.ui.task;


import com.sh3h.datautil.data.DataManager;
import com.sh3h.meterreading.ui.base.ParentPresenter;

import javax.inject.Inject;

public class TaskListPresenter extends ParentPresenter<TaskListMvpView> {

    @Inject
    public TaskListPresenter(DataManager dataManager) {
        super(dataManager);
    }
}
