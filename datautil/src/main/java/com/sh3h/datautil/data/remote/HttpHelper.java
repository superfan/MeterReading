package com.sh3h.datautil.data.remote;

import android.content.Context;

import com.sh3h.datautil.data.entity.DUDeviceResult;
import com.sh3h.datautil.data.entity.DULoginInfo;
import com.sh3h.datautil.data.entity.DULoginResult;
import com.sh3h.datautil.data.local.config.ConfigHelper;
import com.sh3h.datautil.data.local.config.SystemConfig;
import com.sh3h.datautil.data.entity.DUDeviceInfo;
import com.sh3h.datautil.injection.annotation.ApplicationContext;
import com.squareup.otto.Bus;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class HttpHelper {
    private final Context mContext;
    private final ConfigHelper mConfigHelper;
    private final Bus mBus;
    private boolean isConnected;
    private boolean isRestfulApi;
    private RestfulApiService httpService;
    private JsonRpcService jsonRpcService;

    @Inject
    public HttpHelper(@ApplicationContext Context context,
                      ConfigHelper configHelper,
                      Bus bus) {
        mContext = context;
        mConfigHelper = configHelper;
        httpService = null;
        mBus = bus;
        isConnected = false;
        isRestfulApi = false;
        httpService = null;
        jsonRpcService = null;
    }

    /**
     *
     * @param duDeviceInfo
     * @return
     */
    public Observable<DUDeviceResult> authorize(DUDeviceInfo duDeviceInfo) {
        connect();

        if (isRestfulApi) {
            return null;
        } else {
            return jsonRpcService.authorize(duDeviceInfo);
        }
    }

    public Observable<DULoginResult> login(DULoginInfo duLoginInfo) {
        connect();

        if (isRestfulApi) {
            return null;
        } else {
            return jsonRpcService.login(duLoginInfo);
        }
    }

    private void connect() {
        if (isConnected) {
            return;
        }

        SystemConfig systemConfig = mConfigHelper.getSystemConfig();
        String baseUrl = systemConfig.getString(SystemConfig.PARAM_SERVER_BASE_URI);
        isRestfulApi = systemConfig.getBoolean(SystemConfig.PARAM_SYS_RESTFUL_API, false);
        if (isRestfulApi) { // restful api
            httpService = RestfulApiService.Factory.newInstance(mBus, baseUrl);
        } else { // json rpc
            jsonRpcService = new JsonRpcService();
            jsonRpcService.init(baseUrl);
        }
        isConnected = true;
    }
}
