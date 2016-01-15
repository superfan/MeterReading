package com.sh3h.mobileutil.util;

import java.io.IOException;

import android.app.Service;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Vibrator;

public class SystemEquipmentUtil {

	private static MediaPlayer _mplayer = null;

	public static void palySound(Context context, String fileName) {

		if (_mplayer == null || !_mplayer.isPlaying())
			return;

		AssetManager am = context.getAssets();
		try {
			String path = String.format("ring/%s.mp3", fileName);
			AssetFileDescriptor afd = am.openFd(path);
			_mplayer = new MediaPlayer();
			_mplayer.setDataSource(afd.getFileDescriptor(),
					afd.getStartOffset(), afd.getLength());
			_mplayer.prepare();
			_mplayer.start();
		} catch (IOException e) {
			LogUtil.i("SEU", "not found file");
		}

	}

	private static long _lastVibrateTime = 0;

	public static void palyVibrator(Context context) {
		if (_lastVibrateTime != 0) {

			long tmp = System.currentTimeMillis();
			long tmp1 = tmp - _lastVibrateTime;
			_lastVibrateTime = tmp;

			if (tmp1 < 2000) {
				return;
			}
		}

		Vibrator vibrator = (Vibrator) context
				.getSystemService(Service.VIBRATOR_SERVICE);
		vibrator.vibrate(2000);// 振动2秒
	}
}
