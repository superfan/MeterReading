package com.sh3h.meterreading.service;


import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;

import com.sh3h.datautil.data.DataManager;
import com.sh3h.datautil.data.entity.DUFile;
import com.sh3h.datautil.data.entity.DUFileResult;
import com.sh3h.datautil.data.entity.DUUpdateInfo;
import com.sh3h.datautil.data.entity.DUUpdateResult;
import com.sh3h.datautil.data.local.config.ConfigHelper;
import com.sh3h.datautil.data.local.config.VersionConfig;
import com.sh3h.datautil.util.EventPosterHelper;
import com.sh3h.datautil.util.NetworkUtil;
import com.sh3h.meterreading.MainApplication;
import com.sh3h.meterreading.R;
import com.sh3h.meterreading.event.UIBusEvent;
import com.sh3h.meterreading.util.AndroidComponentUtil;
import com.sh3h.meterreading.util.SystemUtil;
import com.sh3h.mobileutil.util.ApplicationsUtil;
import com.sh3h.mobileutil.util.LogUtil;
import com.sh3h.mobileutil.util.TextUtil;
import com.squareup.otto.Bus;

import org.w3c.dom.Text;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

public class VersionService extends Service {
    private static final String TAG = "VersionService";
    private static final String APK_SUFFIX = ".apk";

    @Inject
    DataManager mDataManager;

    @Inject
    ConfigHelper mConfigHelper;

    @Inject
    EventPosterHelper mEventPosterHelper;

    private CompositeSubscription mSubscription;

    private int mAppVersion;
    private int mDataVersion;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, VersionService.class);
    }

    public static boolean isRunning(Context context) {
        return AndroidComponentUtil.isServiceRunning(context, VersionService.class);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MainApplication.get(this).getComponent().inject(this);
        mSubscription = new CompositeSubscription();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        if (!NetworkUtil.isNetworkConnected(this)) {
            ApplicationsUtil.showMessage(this, R.string.text_network_not_connected);
            stopSelf(startId);
            return START_NOT_STICKY;
        }

        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }

        mAppVersion = SystemUtil.getVersionCode(MainApplication.get(this));
        mDataVersion = mConfigHelper.getVersionConfig().getInteger(VersionConfig.DATA_VERSION, 1);
        DUUpdateInfo duUpdateInfo = new DUUpdateInfo(mAppVersion, mDataVersion);
        mSubscription.add(mDataManager.updateVersion(duUpdateInfo)
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<DUFileResult>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.i(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.i(TAG, "onError " + e.getMessage());
                        stopSelf(startId);
                    }

                    @Override
                    public void onNext(DUFileResult duFileResult) {
                        String path = duFileResult.getPath();
                        String name = duFileResult.getName();
                        int percent = duFileResult.getPercent();
                        LogUtil.i(TAG, String.format("---onNext: %s, %d", name, percent));
                        if (name.contains(APK_SUFFIX) && (percent >= 100)) {
                            installLocalApk(path);
                            mEventPosterHelper.postEventSafely(new UIBusEvent.InstallingApk());
                        }
                    }
                }));

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (mSubscription != null) {
            mSubscription.unsubscribe();
        }

        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void installLocalApk(String path) {
        if (path != null) {
            File apk = new File(path);
            // TODO Auto-generated method stub
            /*********下载完成，点击安装***********/
            Uri uri = Uri.fromFile(apk);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            /**********加这个属性是因为使用Context的startActivity方法的话，就需要开启一个新的task**********/
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
            startActivity(intent);
        }
    }
}
