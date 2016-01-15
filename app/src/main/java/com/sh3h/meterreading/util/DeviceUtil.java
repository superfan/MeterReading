package com.sh3h.meterreading.util;


import android.content.Context;
import android.telephony.TelephonyManager;

import com.sh3h.mobileutil.util.TextUtil;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class DeviceUtil {
    private static String macAddress = null;
    private static String deviceId = null;

    /**
     * get mac address
     *
     * @return mac address
     */
    public static String getMacAddress() {
        if (!TextUtil.isNullOrEmpty(macAddress)) {
            return macAddress;
        }

        String str = "";
        try {
            Process pp = Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ");
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);

            for (; null != str; ) {
                str = input.readLine();
                if (str != null) {
                    macAddress = str.trim();
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return macAddress;
    }

    /**
     * get device identification
     * @return device identification
     */
    public static String getDeviceID(Context context) {
        // 已加
        if (!TextUtil.isNullOrEmpty(deviceId)) {
            return deviceId;
        }

        // SharedPreferences sp = this.getSharedPreferences(SPF_UUID,
        // MODE_PRIVATE);
        // this._uuid = sp.getString(KEY_UUID, TextUtil.EMPTY);

        // 已生
        // if (!TextUtil.isNullOrEmpty(_uuid)) {
        // return this._uuid;
        // }
        // 生成
        deviceId = generateUUID(context);

        // Editor ed = sp.edit();
        // ed.putString(KEY_UUID, this._uuid);
        // ed.apply();
        // ed.commit();
        return deviceId;
    }

    private static String generateUUID(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String tmDevice, tmSerial, androidId;

        tmDevice = tm.getDeviceId();
        if (!TextUtil.isNullOrEmpty(tmDevice) && !tmDevice.equals("null")) {
            return tmDevice;
        }

        tmSerial = tm.getSimSerialNumber();
        if (!TextUtil.isNullOrEmpty(tmSerial) && !tmSerial.equals("null")) {
            return tmSerial;
        }

        androidId = android.provider.Settings.Secure.getString(context.getContentResolver(),
                android.provider.Settings.Secure.ANDROID_ID);
        return androidId;

		/*
		 * tmSerial = "" + tm.getSimSerialNumber(); androidId = "" +
		 * android.provider.Settings.Secure.getString(getContentResolver(),
		 * android.provider.Settings.Secure.ANDROID_ID);
		 *
		 * UUID deviceUuid = new UUID(androidId.hashCode(), ((long)
		 * tmDevice.hashCode() << 32) | tmSerial.hashCode());
		 *
		 * return deviceUuid.toString();
		 */
    }
}
