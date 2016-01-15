package com.sh3h.datautil.data.remote;


import com.sh3h.datautil.data.entity.DUDeviceInfo;
import com.sh3h.datautil.data.entity.DUDeviceResult;
import com.sh3h.datautil.data.entity.DULoginInfo;
import com.sh3h.datautil.data.entity.DULoginResult;
import com.sh3h.serverprovider.entity.DeviceInfoEntity;
import com.sh3h.serverprovider.entity.LoginInfoEntity;
import com.sh3h.serverprovider.entity.LoginResultEntity;
import com.sh3h.serverprovider.entity.RegisterResultEntity;
import com.sh3h.serverprovider.rpc.service.BaseApiService;
import com.sh3h.serverprovider.rpc.service.BusinessApiService;
import com.sh3h.serverprovider.rpc.service.SynchronousTaskApiService;
import com.sh3h.serverprovider.rpc.service.SystemApiService;
import com.sh3h.serverprovider.rpc.service.UserApiService;
import com.sh3h.serverprovider.rpc.service.VersionApiService;
import com.sh3h.serverprovider.rpc.service.WorkApiService;

import rx.Observable;
import rx.Subscriber;

public class JsonRpcService {
    private BusinessApiService businessApiService;
    private SynchronousTaskApiService synchronousTaskApiService;
    private SystemApiService systemApiService;
    private UserApiService userApiService;
    private VersionApiService versionApiService;
    private WorkApiService workApiService;

    public JsonRpcService() {
        businessApiService = new BusinessApiService();
        synchronousTaskApiService = new SynchronousTaskApiService();
        systemApiService = new SystemApiService();
        userApiService = new UserApiService();
        versionApiService = new VersionApiService();
        workApiService = new WorkApiService();
    }

    public void init(String baseUrl) {
        BaseApiService.setBaseURL(baseUrl);
    }

    public Observable<DUDeviceResult> authorize(final DUDeviceInfo duDeviceInfo) {
        return Observable.create(new Observable.OnSubscribe<DUDeviceResult>() {
            @Override
            public void call(Subscriber<? super DUDeviceResult> subscriber) {
                try {
                    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
                    deviceInfoEntity.setDeviceID(duDeviceInfo.getDeviceID());
                    deviceInfoEntity.setMACAddress(duDeviceInfo.getMacAddress());
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

    public Observable<DULoginResult> login(final DULoginInfo duLoginInfo) {
        return Observable.create(new Observable.OnSubscribe<DULoginResult>() {
            @Override
            public void call(Subscriber<? super DULoginResult> subscriber) {
                try {
                    LoginInfoEntity loginInfoEntity = new LoginInfoEntity();
                    loginInfoEntity.setAccount(duLoginInfo.getAccount());
                    loginInfoEntity.setPassword(duLoginInfo.getPassword());
                    LoginResultEntity loginResultEntity =
                            userApiService.Login(loginInfoEntity);
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
}
