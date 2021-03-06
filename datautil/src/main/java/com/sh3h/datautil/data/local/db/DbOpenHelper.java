package com.sh3h.datautil.data.local.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sh3h.datautil.injection.annotation.ApplicationContext;

import javax.inject.Inject;

@Deprecated
public class DbOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ribots.db";
    public static final int DATABASE_VERSION = 2;

    @Inject
    public DbOpenHelper(@ApplicationContext Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        try {
            //Uncomment line below if you want to enable foreign keys
            //db.execSQL("PRAGMA foreign_keys=ON;");
            db.execSQL(Db.RibotProfileTable.CREATE);
            //Add other tables here
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }
}
