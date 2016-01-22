package com.sh3h.datautil.data.remote;


import com.sh3h.datautil.data.entity.DUDeviceInfo;
import com.sh3h.datautil.data.entity.DUDeviceResult;
import com.sh3h.datautil.data.entity.DULoginInfo;
import com.sh3h.datautil.data.entity.DULoginResult;
import com.sh3h.datautil.data.entity.DUTask;
import com.sh3h.datautil.data.entity.DUTaskIdInfo;
import com.sh3h.datautil.data.entity.DUTaskIdResult;
import com.sh3h.datautil.data.entity.DUTaskInfo;
import com.sh3h.datautil.data.entity.DUTaskResult;
import com.sh3h.datautil.data.entity.DUUpdateInfo;
import com.sh3h.datautil.data.entity.DUUpdateResult;
import com.sh3h.datautil.data.entity.DUUserInfo;
import com.sh3h.datautil.data.entity.DUUserResult;
import com.sh3h.serverprovider.entity.ChaoBiaoRWEntity;
import com.sh3h.serverprovider.entity.ClientInfoEntity;
import com.sh3h.serverprovider.entity.DeviceInfoEntity;
import com.sh3h.serverprovider.entity.LoginInfoEntity;
import com.sh3h.serverprovider.entity.LoginResultEntity;
import com.sh3h.serverprovider.entity.RegisterResultEntity;
import com.sh3h.serverprovider.entity.RenWuXXEntity;
import com.sh3h.serverprovider.entity.UpdateInfoEntity;
import com.sh3h.serverprovider.entity.UserInfoEntity;
import com.sh3h.serverprovider.rpc.service.BaseApiService;
import com.sh3h.serverprovider.rpc.service.BusinessApiService;
import com.sh3h.serverprovider.rpc.service.SynchronousTaskApiService;
import com.sh3h.serverprovider.rpc.service.SystemApiService;
import com.sh3h.serverprovider.rpc.service.UserApiService;
import com.sh3h.serverprovider.rpc.service.VersionApiService;
import com.sh3h.serverprovider.rpc.service.WorkApiService;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class JsonRpcService {
    public JsonRpcService() {
//        businessApiService = new BusinessApiService();
//        synchronousTaskApiService = new SynchronousTaskApiService();
//        systemApiService = new SystemApiService();
//        workApiService = new WorkApiService();
    }

    public void init(String baseUrl) {
        BaseApiService.setBaseURL(baseUrl);
    }

    /**
     * authorize
     * @param duDeviceInfo
     * @return
     */
    public Observable<DUDeviceResult> authorize(final DUDeviceInfo duDeviceInfo) {
        return Observable.create(new Observable.OnSubscribe<DUDeviceResult>() {
            @Override
            public void call(Subscriber<? super DUDeviceResult> subscriber) {
                try {
                    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
                    deviceInfoEntity.setDeviceID(duDeviceInfo.getDeviceID());
                    deviceInfoEntity.setMACAddress(duDeviceInfo.getMacAddress());
                    SystemApiService systemApiService = new SystemApiService();
                    RegisterResultEntity registerResultEntity =
                            systemApiService.registerMachine(deviceInfoEntity);
                    if (registerResultEntity != null) {
                        DUDeviceResult duDeviceResult = new DUDeviceResult(
                                registerResultEntity.getSuccessed(),
                                registerResultEntity.getCode(),
                                registerResultEntity.getError(),
                                registerResultEntity.getJiHuoZT(),
                                registerResultEntity.getJiHuoSJ(),
                                registerResultEntity.getSheBeiZT());
                        subscriber.onNext(duDeviceResult);
                    } else {
                        subscriber.onError(new Throwable("registerResultEntity is null"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    subscriber.onError(new Throwable(e.getMessage()));
                } finally {
                    subscriber.onCompleted();
                }
            }
        });
    }

    /**
     * login
     * @param duLoginInfo
     * @return
     */
    public Observable<DULoginResult> login(final DULoginInfo duLoginInfo) {
        return Observable.create(new Observable.OnSubscribe<DULoginResult>() {
            @Override
            public void call(Subscriber<? super DULoginResult> subscriber) {
                try {
                    LoginInfoEntity loginInfoEntity = new LoginInfoEntity();
                    loginInfoEntity.setAccount(duLoginInfo.getAccount());
                    loginInfoEntity.setPassword(duLoginInfo.getPassword());
                    UserApiService userApiService = new UserApiService();
                    LoginResultEntity loginResultEntity = userApiService.Login(loginInfoEntity);
                    if (loginResultEntity != null) {
                        DULoginResult duLoginResult = new DULoginResult(
                                loginResultEntity.getError(),
                                loginResultEntity.get_UserID());
                        subscriber.onNext(duLoginResult);
                    } else {
                        subscriber.onError(new Throwable("loginResultEntity is null"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    subscriber.onError(new Throwable(e.getMessage()));
                } finally {
                    subscriber.onCompleted();
                }
            }
        });
    }

    /**
     * get user information
     * @param duUserInfo
     * @return
     */
    public Observable<DUUserResult> getUserInfo(final DUUserInfo duUserInfo) {
        return Observable.create(new Observable.OnSubscribe<DUUserResult>() {
            @Override
            public void call(Subscriber<? super DUUserResult> subscriber) {
                try {
                    UserApiService userApiService = new UserApiService();
                    UserInfoEntity userInfoEntity = userApiService.getUserInfo(duUserInfo.getUserId());
                    if (userInfoEntity != null) {
                        DUUserResult duLoginResult = new DUUserResult(
                                userInfoEntity.getUserId(),
                                userInfoEntity.getUserName(),
                                userInfoEntity.getAccount(),
                                userInfoEntity.getPWS(),
                                userInfoEntity.getCellPhone(),
                                userInfoEntity.getPhone(),
                                userInfoEntity.getAddress());
                        subscriber.onNext(duLoginResult);
                    } else {
                        subscriber.onError(new Throwable("userInfoEntity is null"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    subscriber.onError(new Throwable(e.getMessage()));
                } finally {
                    subscriber.onCompleted();
                }
            }
        });
    }

    /**
     *
     * @param duUpdateInfo
     * @return
     */
    public Observable<DUUpdateResult> updateVersion(final DUUpdateInfo duUpdateInfo) {
        return Observable.create(new Observable.OnSubscribe<DUUpdateResult>() {
            @Override
            public void call(Subscriber<? super DUUpdateResult> subscriber) {
                try {
                    ClientInfoEntity clientInfoEntity = new ClientInfoEntity();
                    clientInfoEntity.setAppVersion(duUpdateInfo.getAppVersion());
                    clientInfoEntity.setDataVersion(duUpdateInfo.getDataVersion());
                    VersionApiService versionApiService = new VersionApiService();
                    UpdateInfoEntity updateInfoEntity = versionApiService.hasNewUpdate(clientInfoEntity);
                    if (updateInfoEntity != null) {
                        DUUpdateResult duUpdateResult = new DUUpdateResult();
                        List<UpdateInfoEntity.Item> srcItems = updateInfoEntity.getItems();
                        List<DUUpdateResult.Item> destItems = new ArrayList<>();
                        for (UpdateInfoEntity.Item srcItem : srcItems) {
                            DUUpdateResult.Item destItem = new DUUpdateResult.Item(srcItem.getType().ordinal(),
                                    srcItem.isEnable(), srcItem.getVersion(), srcItem.getDesc(),
                                    srcItem.getUrl());
                            destItems.add(destItem);
                        }
                        duUpdateResult.setItemList(destItems);
                        duUpdateResult.setDuUpdateInfo(duUpdateInfo);
                        subscriber.onNext(duUpdateResult);
                    } else {
                        subscriber.onError(new Throwable("userInfoEntity is null"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    subscriber.onError(new Throwable(e.getMessage()));
                } finally {
                    subscriber.onCompleted();
                }
            }
        });
    }

    public Observable<DUTaskIdResult> getTaskIds(final DUTaskIdInfo duTaskIdInfo) {
        return Observable.create(new Observable.OnSubscribe<DUTaskIdResult>() {
            @Override
            public void call(Subscriber<? super DUTaskIdResult> subscriber) {
                try {
                    SynchronousTaskApiService synchronousTaskApiService = new SynchronousTaskApiService();
                    RenWuXXEntity renWuXXEntity = synchronousTaskApiService.getRenWuBHByChaoBiaoY(duTaskIdInfo.getAccount());
                    if ((renWuXXEntity != null)
                            && (renWuXXEntity.get_message() != null)
                            && (renWuXXEntity.get_message().equals(RenWuXXEntity.SUCCESS_MESSAGE))
                            && (renWuXXEntity.get_renwus() != null)) {
                        DUTaskIdResult duTaskIdResult = new DUTaskIdResult();
                        List<String> taskIdList = new ArrayList<>();
                        duTaskIdResult.setIdList(taskIdList);

                        String taskIds = renWuXXEntity.get_renwus();
                        String[] ids = taskIds.split(",");
                        for (String id : ids) {
                            if (id.equals("") || id.equals(",")) {
                                continue;
                            }
                            taskIdList.add(id);
                        }

                        subscriber.onNext(duTaskIdResult);
                    } else {
                        subscriber.onError(new Throwable("userInfoEntity is null"));
                    }
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
                    SynchronousTaskApiService synchronousTaskApiService = new SynchronousTaskApiService();
                    String account = duTaskInfo.getAccount();
                    int taskId = duTaskInfo.getTaskId();
                    String deviceid = duTaskInfo.getDeviceId();
                    List<ChaoBiaoRWEntity> chaoBiaoRWEntities =
                            synchronousTaskApiService.downLoadChaoBiaoRW(taskId, deviceid, account);
                    if (chaoBiaoRWEntities != null) {
                        DUTaskResult duTaskResult = new DUTaskResult();
                        List<DUTask> duTaskList = new ArrayList<>();
                        for (ChaoBiaoRWEntity chaoBiaoRWEntity : chaoBiaoRWEntities) {
                            DUTask duTask = new DUTask(
                                    chaoBiaoRWEntity.getId(),
                                    chaoBiaoRWEntity.getRenWuBH(),
                                    chaoBiaoRWEntity.getChaoBiaoYBH(),
                                    chaoBiaoRWEntity.getPaiFaSJ(),
                                    chaoBiaoRWEntity.getchaoBiaoYXM(),
                                    chaoBiaoRWEntity.getZhangWuNY(),
                                    chaoBiaoRWEntity.getCH(),
                                    chaoBiaoRWEntity.getCeBenMC(),
                                    chaoBiaoRWEntity.getGongCi(),
                                    chaoBiaoRWEntity.getST(),
                                    chaoBiaoRWEntity.getZongShu(),
                                    chaoBiaoRWEntity.getYiChaoShu(),
                                    chaoBiaoRWEntity.getChaoBiaoZQ(),
                                    0);
                            duTaskList.add(duTask);
                        }

                        duTaskResult.setDUTaskList(duTaskList);
                        subscriber.onNext(duTaskResult);
                    } else {
                        subscriber.onError(new Throwable("userInfoEntity is null"));
                    }
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
