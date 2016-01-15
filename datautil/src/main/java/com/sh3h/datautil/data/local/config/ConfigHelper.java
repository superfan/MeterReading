package com.sh3h.datautil.data.local.config;


import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;

import com.sh3h.datautil.injection.annotation.ApplicationContext;
import com.sh3h.mobileutil.util.LogUtil;
import com.sh3h.mobileutil.util.TextUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;

import rx.Observable;
import rx.Subscriber;

import javax.inject.Inject;

public class ConfigHelper {
    public static final File STORAGE_PATH = Environment.getExternalStorageDirectory();
    /**
     * 根目录
     */
    public static final String FOLDER_ROOT = "sh3h/meterreading";
    /**
     * 配置文件目录
     */
    public static final String FOLDER_CONFIG = FOLDER_ROOT + "/config";
    /**
     * 多用户配置文件目录
     */
    public static final String FOLDER_USER = FOLDER_ROOT + "/user";
    /**
     * 数据配置文件目录
     */
    public static final String FOLDER_DATA = FOLDER_ROOT + "/data";
    /**
     * 激活文件目录
     */
    public static final String FOLDER_KEY = FOLDER_ROOT + "/key";

    /**
     * 图片存储目录
     */
    public static final String FOLDER_IMAGES = FOLDER_ROOT + "/images";

    /**
     * 图片存储目录
     */
    public static final String QIANMING_IMAGES = FOLDER_IMAGES + "/signature";

    /**
     * 声音存储目录
     */
    public static final String FOLDER_SOUNDS = FOLDER_ROOT + "/sounds";
    /**
     * 更新文件存储目录
     */
    public static final String FOLDER_UPDATE = FOLDER_ROOT + "/update";

    /**
     * www文件存储目录
     */
    public static final String FOLDER_WWW = FOLDER_ROOT + "/www";

    /**
     * 日志文件存储目录
     */
    public static final String FOLDER_LOG = FOLDER_ROOT + "/log";

    /**
     * 用户配置文件名
     */
    public static final String FILE_USER_CONFIG = "user.properties";

    /**
     * 用户登录信息文件名
     */
    public static final String FILE_USER_LOGIN = "login.properties";

    /**
     * 版本记录号
     */
    public static final String FILE_VERSION_UPDATE = "versions.properties";
    /**
     * 系统参数文件名
     */
    public static final String FILE_SYSTEM_CONFIG = "system.properties";

    /**
     * Map参数文件名
     */
    public static final String FILE_MAP_CONFIG = "map.properties";

    /**
     * 用户配置文件名
     */
    public static final String FILE_USER = "users.xml";
    /**
     * 在线用户配置文件名
     */
    public static final String FILE_ONLINE_USER = "online-users.xml";
    /**
     * 词语配置文件名
     */
    public static final String FILE_WORDS = "words.xml";
    /**
     * 数据库文件名
     */
    public static final String DB_NAME = "main.cbj";
    /**
     * 激活文件名
     */
    public static final String FILE_KEY_CONFIG = "key.properties";


    private final Context mContext;
    private final SystemConfig mSystemConfig;
    private final MapConfig mMapConfig;
    private final VersionConfig mVersionConfig;
    private final KeyConfig mKeyConfig;

    @Inject
    public ConfigHelper(@ApplicationContext Context context) {
        mContext = context;
        mSystemConfig = new SystemConfig();
        mMapConfig = new MapConfig();
        mVersionConfig = new VersionConfig();
        mKeyConfig = new KeyConfig();
    }

    public Observable<Void> initDefaultConfigs() {
        return Observable.create(new Observable.OnSubscribe<Void>() {
            @Override
            public void call(Subscriber<? super Void> subscriber) {
                if (!initDefaultConfigFiles()) {
                    subscriber.onError(new Throwable("initDefaultConfigFiles is failure"));
                }
                subscriber.onCompleted();
            }
        });
    }

    /**
     * initialize configure files
     *
     * @return true: success
     */
    private boolean initDefaultConfigFiles() {
        try {
            // config
            File configDir = new File(STORAGE_PATH, FOLDER_CONFIG);
            if (!configDir.exists()) {
                // 创建 FOLDER_CONFIG
                configDir.mkdirs();
            }

            // 遍历 assets/config 文件夹，在sd卡不存在则复制
            AssetManager assetManager = mContext.getAssets();
            String[] configFiles = assetManager.list("config");
            if (configFiles.length > 0) {
                for (String fileName : configFiles) {
                    File outputFile = new File(STORAGE_PATH, FOLDER_CONFIG + "/" + fileName);
                    if (!outputFile.exists()) {
                        InputStream is = assetManager.open("config/" + fileName);
                        FileOutputStream fos = new FileOutputStream(outputFile);
                        byte[] buffer = new byte[256];
                        for (int count = is.read(buffer); count > 0; ) {
                            fos.write(buffer, 0, count);
                            count = is.read(buffer);
                        }

                        fos.flush();
                        fos.close();
                        is.close();
                    }
                }
            }

            // data
            File dataDir = new File(STORAGE_PATH, FOLDER_DATA);
            if (!dataDir.exists()) {
                dataDir.mkdirs();
            }

            String[] dataFiles = assetManager.list("data");
            if (dataFiles.length > 0) {
                for (String fileName : dataFiles) {
                    File outputFile = new File(STORAGE_PATH, FOLDER_DATA + "/" + fileName);
                    if (!outputFile.exists()) {
                        InputStream is = assetManager.open("data/" + fileName);
                        FileOutputStream fos = new FileOutputStream(outputFile);
                        byte[] buffer = new byte[256];
                        for (int count = is.read(buffer); count > 0; ) {
                            fos.write(buffer, 0, count);
                            count = is.read(buffer);
                        }

                        fos.flush();
                        fos.close();
                        is.close();
                    }
                }
            }

            // key
            File keyDir = new File(STORAGE_PATH, FOLDER_KEY);
            if (!keyDir.exists()) {
                keyDir.mkdirs();
            }

            String[] keyFiles = assetManager.list("key");
            if (keyFiles.length > 0) {
                for (String fileName : keyFiles) {
                    File outputFile = new File(STORAGE_PATH, FOLDER_KEY + "/" + fileName);
                    if (!outputFile.exists()) {
                        InputStream is = assetManager.open("key/" + fileName);
                        FileOutputStream fos = new FileOutputStream(outputFile);
                        byte[] buffer = new byte[256];
                        for (int count = is.read(buffer); count > 0; ) {
                            fos.write(buffer, 0, count);
                            count = is.read(buffer);
                        }

                        fos.flush();
                        fos.close();
                        is.close();
                    }
                }
            }

            // image
            File imagesDir = new File(STORAGE_PATH, FOLDER_IMAGES);
            if (!imagesDir.exists()) {
                imagesDir.mkdirs();
            }

            // signature
            File signature = new File(STORAGE_PATH, QIANMING_IMAGES);
            if (!signature.exists()) {
                signature.mkdirs();
            }

            // sound
            File soundsDir = new File(STORAGE_PATH, FOLDER_SOUNDS);
            if (!soundsDir.exists()) {
                soundsDir.mkdirs();
            }

            // update
            File updateDir = new File(STORAGE_PATH, FOLDER_UPDATE);
            if (!updateDir.exists()) {
                updateDir.mkdirs();
            }

//            File version = new File(updateDir, FILE_VERSION_UPDATE);
//            if (!version.exists()) {
//                ConfigHelper.LoadDefaultSystemVersion().writeToFile(version.getPath());
//            }

            // log
            File logDir = new File(STORAGE_PATH, FOLDER_LOG);
            if (!logDir.exists()) {
                logDir.mkdirs();
            }

            // user
            File userDir = new File(STORAGE_PATH, FOLDER_USER);
            if (!userDir.exists()) {
                userDir.mkdirs();
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * get the path of system.properties
     * @return file path
     */
    public File getSystemConfigFilePath() {
        File dir = new File(STORAGE_PATH, FOLDER_CONFIG);
        return new File(dir, FILE_SYSTEM_CONFIG);
    }

    /**
     * get the path of log file
     * @return file path
     */
    public File getLogFilePath() {
        File dir = new File(STORAGE_PATH, FOLDER_LOG);
        String name = String.format("log-%s", TextUtil.format(new Date(), TextUtil.FORMAT_DATE));
        return new File(dir, name);
    }

    /**
     *
     * @return
     */
    public static File getKeyFilePath() {
        File dir = new File(STORAGE_PATH, FOLDER_KEY);
        return new File(dir, FILE_KEY_CONFIG);
    }

    public SystemConfig getSystemConfig() {
        if (!mSystemConfig.isRead()) {
            mSystemConfig.readProperties(getSystemConfigFilePath().getPath());
        }
        return mSystemConfig;
    }

    public KeyConfig getKeyConfig() {
        if (!mKeyConfig.isRead()) {
            mKeyConfig.readProperties(getKeyFilePath().getPath());
        }
        return mKeyConfig;
    }

    public String getKey() {
        return getKeyConfig().getString(KeyConfig.PARAM_KEY);
    }

    public void setKey(String key) {
        getKeyConfig().set(KeyConfig.PARAM_KEY, key);
        getKeyConfig().writeProperties(getKeyFilePath().getPath());
    }
}
