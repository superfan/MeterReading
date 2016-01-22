package com.sh3h.datautil.data.local.db;

import android.content.Context;

import com.sh3h.dataprovider.DBManager;
import com.sh3h.dataprovider.greendaoEntity.ChaoBiaoRW;
import com.sh3h.datautil.data.entity.DUTask;
import com.sh3h.datautil.data.entity.DUTaskInfo;
import com.sh3h.datautil.data.entity.DUTaskResult;
import com.sh3h.datautil.data.local.config.ConfigHelper;
import com.sh3h.datautil.injection.annotation.ApplicationContext;
import com.sh3h.mobileutil.util.LogUtil;
import com.sh3h.serverprovider.entity.ChaoBiaoRWEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;

@Singleton
public class DbHelper {
    private static final String TAG = "DbHelper";

    private final Context mContext;
    private final ConfigHelper mConfigHelper;
    private boolean mIsInit;

    @Inject
    public DbHelper(@ApplicationContext Context context,
                    ConfigHelper configHelper) {
        mContext = context;
        mConfigHelper = configHelper;
        mIsInit = false;
    }

    /**
     * initialize
     */
    public synchronized void init() {
        if (!mIsInit) {
            mIsInit = true;
            DBManager.getInstance().init(mConfigHelper.getDBFilePath().getPath(), mContext);
        }
    }

    /**
     * destroy
     */
    public void destroy() {
        if (mIsInit) {
            mIsInit = false;
            DBManager.getInstance().destroy();
        }
    }

    /**
     *
     * @param duTaskResult
     */
    public void saveTask(DUTaskResult duTaskResult) {
        try {
            init();

            List<DUTask> duTaskList =  duTaskResult.getDUTaskList();
            if (duTaskList != null) {
                for (DUTask duTask : duTaskList) {
                    ChaoBiaoRW chaoBiaoRW = new ChaoBiaoRW(
                            duTask.getId(),
                            duTask.getRenWuBH(),
                            duTask.getChaoBiaoYBH(),
                            duTask.getChaoBiaoYXM(),
                            duTask.getPaiFaSJ(),
                            duTask.getZhangWuNY(),
                            duTask.getcH(),
                            duTask.getCeBenMC(),
                            duTask.getChaoBiaoZQ(),
                            duTask.getGongCi(),
                            duTask.getsT(),
                            duTask.getZongShu(),
                            duTask.getYiChaoShu(),
                            duTask.getTongBuBZ());
                    DBManager.getInstance().insertChaoBiaoRW(chaoBiaoRW);
                }
            } else {
                LogUtil.i(TAG, "---saveTask: duTaskList is null---");
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i(TAG, String.format("---saveTask---%s", e.getMessage()));
        }
    }

    public Observable<DUTaskResult> getTasks(final DUTaskInfo duTaskInfo) {
        return Observable.create(new Observable.OnSubscribe<DUTaskResult>() {
            @Override
            public void call(Subscriber<? super DUTaskResult> subscriber) {
                try {
                    init();

                    List<ChaoBiaoRW> chaoBiaoRWList =
                            DBManager.getInstance().getChaoBiaoRWList(duTaskInfo.getAccount());
                    DUTaskResult duTaskResult = new DUTaskResult();
                    if (chaoBiaoRWList != null) {
                        List<DUTask> duTaskList = new ArrayList<>();
                        for (ChaoBiaoRW chaoBiaoRW : chaoBiaoRWList) {
                            DUTask duTask = new DUTask(
                                    chaoBiaoRW.getID(),
                                    chaoBiaoRW.getI_RenWuBH(),
                                    chaoBiaoRW.getS_ChaoBiaoYBH(),
                                    chaoBiaoRW.getD_PaiFaSJ(),
                                    chaoBiaoRW.getS_ChaoBiaoYXM(),
                                    chaoBiaoRW.getI_ZhangWuNY(),
                                    chaoBiaoRW.getS_CH(),
                                    chaoBiaoRW.getS_CeBenMC(),
                                    chaoBiaoRW.getI_GongCi(),
                                    chaoBiaoRW.getS_ST(),
                                    chaoBiaoRW.getI_ZongShu(),
                                    chaoBiaoRW.getI_YiChaoShu(),
                                    chaoBiaoRW.getS_CHAOBIAOZQ(),
                                    chaoBiaoRW.getI_TongBuBZ());
                            duTaskList.add(duTask);
                        }

                        duTaskResult.setDUTaskList(duTaskList);
                    } else {
                        LogUtil.i(TAG, "---getTasks: chaoBiaoRWList is null---");
                    }

                    subscriber.onNext(duTaskResult);
                } catch (Exception e) {
                    e.printStackTrace();
                    subscriber.onError(new Throwable(e.getMessage()));
                } finally {
                    subscriber.onCompleted();
                }
            }
        });
    }

    public Observable<DUTaskResult> getTask(final DUTaskInfo duTaskInfo) {
        return Observable.create(new Observable.OnSubscribe<DUTaskResult>() {
            @Override
            public void call(Subscriber<? super DUTaskResult> subscriber) {
                try {
                    init();

                    ChaoBiaoRW chaoBiaoRW = DBManager.getInstance().getChaoBiaoRW(duTaskInfo.getAccount(),
                            duTaskInfo.getTaskId(), duTaskInfo.getVolume());
                    DUTaskResult duTaskResult = new DUTaskResult();
                    if (chaoBiaoRW != null) {
                        List<DUTask> duTaskList = new ArrayList<>();
                        DUTask duTask = new DUTask(
                                chaoBiaoRW.getID(),
                                chaoBiaoRW.getI_RenWuBH(),
                                chaoBiaoRW.getS_ChaoBiaoYBH(),
                                chaoBiaoRW.getD_PaiFaSJ(),
                                chaoBiaoRW.getS_ChaoBiaoYXM(),
                                chaoBiaoRW.getI_ZhangWuNY(),
                                chaoBiaoRW.getS_CH(),
                                chaoBiaoRW.getS_CeBenMC(),
                                chaoBiaoRW.getI_GongCi(),
                                chaoBiaoRW.getS_ST(),
                                chaoBiaoRW.getI_ZongShu(),
                                chaoBiaoRW.getI_YiChaoShu(),
                                chaoBiaoRW.getS_CHAOBIAOZQ(),
                                chaoBiaoRW.getI_TongBuBZ());
                        duTaskList.add(duTask);

                        duTaskResult.setDUTaskList(duTaskList);
                    } else {
                        LogUtil.i(TAG, "---getTask: chaoBiaoRW is null---");
                    }

                    subscriber.onNext(duTaskResult);
                } catch (Exception e) {
                    e.printStackTrace();
                    subscriber.onError(new Throwable(e.getMessage()));
                } finally {
                    subscriber.onCompleted();
                }
            }
        });
    }
}
