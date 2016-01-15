/**
 * @author qiweiwei
 *
 */
package com.sh3h.mobileutil.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

public class LogUtil {
	private static Logger _logger = null;

	public synchronized static void initLogger(String path) {
		if (path == null) {
			return;
		}

//		File sdDir = Environment.getExternalStorageDirectory();
//		File logDir = new File(sdDir, folder);
//		if (!logDir.exists()) {
//			logDir.mkdirs();
//		}
//
//		String name = String.format("log-%s", TextUtil.format(new Date(), TextUtil.FORMAT_DATE));
//		File logFile = new File(logDir, name);

		try {
			LogManager lm = LogManager.getLogManager();
			_logger = lm.getLogger(TextUtil.EMPTY);
			_logger.addHandler(new FileHandler(path));
			_logger.setLevel(Level.ALL);
		} catch (IOException e) {
			e.printStackTrace();
			_logger = null;
		}
	}

//	private static void initLogWithFluentAPI(LogManager lm, String logFilePath) {
//		_logger = lm.getLogger(TextUtil.EMPTY);
//		// _logger = LogManager.getLogManager().getLogger("MAIN");
//
//		//_logger.addHandler(new ConsoleHandler());
//
//		try {
//			_logger.addHandler(new FileHandler(logFilePath));
//			_logger.setLevel(Level.ALL);
//		} catch (IOException e) {
//			e.printStackTrace();
//			_logger = null;
//			return;
//		}
//
//		//_logger.addHandler(new AndroidHandler());
//	}

	public synchronized static void d(String tag, String msg) {
		append(Level.CONFIG, tag, msg);
	}

	public synchronized static void d(String tag, String format, Object... args) {
		append(Level.CONFIG, tag, format, args);
	}

	public synchronized static void i(String tag, String msg) {
		append(Level.INFO, tag, msg);
	}

	public synchronized static void i(String tag, String format, Object... args) {
		append(Level.INFO, tag, format, args);
	}

	public synchronized static void w(String tag, String msg) {
		append(Level.WARNING, tag, msg);
	}

	public synchronized static void w(String tag, String format, Object... args) {
		append(Level.WARNING, tag, format, args);
	}

	public synchronized static void w(String tag, String msg, Throwable tr) {
		append(Level.WARNING, tag, msg);
	}

	public synchronized static void w(String tag, Throwable tr, String format, Object... args) {
		append(Level.WARNING, tag, tr, format, args);
	}

	public synchronized static void e(String tag, String msg) {
		append(Level.SEVERE, tag, msg);
	}

	public synchronized static void e(String tag, String format, Object... args) {
		append(Level.SEVERE, tag, format, args);
	}

	public synchronized static void e(String tag, String msg, Throwable tr) {
		append(Level.SEVERE, tag, msg, tr);
	}

	public synchronized static void e(String tag, Throwable tr, String format, Object... args) {
		append(Level.SEVERE, tag, tr, format, args);
	}

	private synchronized static void append(Level level, String tag, Throwable tr, String format, Object[] args) {
		append(level, tag, String.format(format, args), tr);
	}

	private synchronized static void append(Level level, String tag, String msg, Throwable tr) {
		Log.i(tag, msg);
		if (_logger != null) {
			_logger.log(level, String.format("TAG:%s, %s", tag, msg), tr);
		}
	}

	private synchronized static void append(Level level, String tag, String format, Object[] args) {
		append(level, tag, String.format(format, args));
	}

	private synchronized static void append(Level level, String tag, String msg) {
		Log.i(tag, msg);
		if (_logger != null) {
			_logger.log(level, String.format("TAG:%s, %s", tag, msg));
		}
	}
}
