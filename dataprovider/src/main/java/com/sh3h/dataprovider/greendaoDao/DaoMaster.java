package com.sh3h.dataprovider.greendaoDao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;

import com.sh3h.dataprovider.greendaoDao.ChaoBiaoRWDao;
import com.sh3h.dataprovider.greendaoDao.ChaoBiaoSJDao;
import com.sh3h.dataprovider.greendaoDao.ChaoBiaoBZDao;
import com.sh3h.dataprovider.greendaoDao.ChaoBiaoGJDao;
import com.sh3h.dataprovider.greendaoDao.ChaoBiaoJLDao;
import com.sh3h.dataprovider.greendaoDao.HuanBiaoJLDao;
import com.sh3h.dataprovider.greendaoDao.CiYuXXDao;
import com.sh3h.dataprovider.greendaoDao.XinXiBGDao;
import com.sh3h.dataprovider.greendaoDao.FeiYongZKLDao;
import com.sh3h.dataprovider.greendaoDao.WordsInfoDao;
import com.sh3h.dataprovider.greendaoDao.DingEJJBLDao;
import com.sh3h.dataprovider.greendaoDao.FeiYongZCDao;
import com.sh3h.dataprovider.greendaoDao.ShuiLiangFTXXDao;
import com.sh3h.dataprovider.greendaoDao.JianHaoMXDao;
import com.sh3h.dataprovider.greendaoDao.ReXianGDDao;
import com.sh3h.dataprovider.greendaoDao.JianHaoDao;
import com.sh3h.dataprovider.greendaoDao.ChaoBiaoRWDao;
import com.sh3h.dataprovider.greendaoDao.ChaoBiaoSJDao;
import com.sh3h.dataprovider.greendaoDao.ChaoBiaoZTDao;
import com.sh3h.dataprovider.greendaoDao.ChaoBiaoZTFLDao;
import com.sh3h.dataprovider.greendaoDao.DuoMeiTXXDao;
import com.sh3h.dataprovider.greendaoDao.GuiJiDao;
import com.sh3h.dataprovider.greendaoDao.NeiFuBZDao;
import com.sh3h.dataprovider.greendaoDao.ZhuangTaiLXCSDao;
import com.sh3h.dataprovider.greendaoDao.BIAOKAXXDao;
import com.sh3h.dataprovider.greendaoDao.DengLuLSDao;
import com.sh3h.dataprovider.greendaoDao.MetaInfoDao;
import com.sh3h.dataprovider.greendaoDao.BiaoWuGDDao;
import com.sh3h.dataprovider.greendaoDao.RenwuXXDao;
import com.sh3h.dataprovider.greendaoDao.UsersDao;
import com.sh3h.dataprovider.greendaoDao.WaiFuGDDetailDao;
import com.sh3h.dataprovider.greendaoDao.WaiFuGDMainDao;
import com.sh3h.dataprovider.greendaoDao.WaiFuYYDao;
import com.sh3h.dataprovider.greendaoDao.YanChiBiaoDao;
import com.sh3h.dataprovider.greendaoDao.JiaoFeiXXDao;
import com.sh3h.dataprovider.greendaoDao.GongGaoXXDao;
import com.sh3h.dataprovider.greendaoDao.YuanGongXXDao;
import com.sh3h.dataprovider.greendaoDao.UserInfoDao;
import com.sh3h.dataprovider.greendaoDao.JinEXXDao;
import com.sh3h.dataprovider.greendaoDao.QianFeiXXDao;

import java.io.File;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * Master of DAO (schema version 1): knows all DAOs.
*/
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 1;

    private static SQLiteDatabase db = null;
    /** Creates underlying database table using DAOs. */
    public static void createAllTables(SQLiteDatabase db, boolean ifNotExists) {
        ChaoBiaoRWDao.createTable(db, ifNotExists);
        ChaoBiaoSJDao.createTable(db, ifNotExists);
        ChaoBiaoBZDao.createTable(db, ifNotExists);
        ChaoBiaoGJDao.createTable(db, ifNotExists);
        ChaoBiaoJLDao.createTable(db, ifNotExists);
        HuanBiaoJLDao.createTable(db, ifNotExists);
        CiYuXXDao.createTable(db, ifNotExists);
        XinXiBGDao.createTable(db, ifNotExists);
        FeiYongZKLDao.createTable(db, ifNotExists);
        WordsInfoDao.createTable(db, ifNotExists);
        DingEJJBLDao.createTable(db, ifNotExists);
        FeiYongZCDao.createTable(db, ifNotExists);
        ShuiLiangFTXXDao.createTable(db, ifNotExists);
        JianHaoMXDao.createTable(db, ifNotExists);
        ReXianGDDao.createTable(db, ifNotExists);
        JianHaoDao.createTable(db, ifNotExists);
        ChaoBiaoRWDao.createTable(db, ifNotExists);
        ChaoBiaoSJDao.createTable(db, ifNotExists);
        ChaoBiaoZTDao.createTable(db, ifNotExists);
        ChaoBiaoZTFLDao.createTable(db, ifNotExists);
        DuoMeiTXXDao.createTable(db, ifNotExists);
        GuiJiDao.createTable(db, ifNotExists);
        NeiFuBZDao.createTable(db, ifNotExists);
        ZhuangTaiLXCSDao.createTable(db, ifNotExists);
        BIAOKAXXDao.createTable(db, ifNotExists);
        DengLuLSDao.createTable(db, ifNotExists);
        MetaInfoDao.createTable(db, ifNotExists);
        BiaoWuGDDao.createTable(db, ifNotExists);
        RenwuXXDao.createTable(db, ifNotExists);
        UsersDao.createTable(db, ifNotExists);
        WaiFuGDDetailDao.createTable(db, ifNotExists);
        WaiFuGDMainDao.createTable(db, ifNotExists);
        WaiFuYYDao.createTable(db, ifNotExists);
        YanChiBiaoDao.createTable(db, ifNotExists);
        JiaoFeiXXDao.createTable(db, ifNotExists);
        GongGaoXXDao.createTable(db, ifNotExists);
        YuanGongXXDao.createTable(db, ifNotExists);
        UserInfoDao.createTable(db, ifNotExists);
        JinEXXDao.createTable(db, ifNotExists);
        QianFeiXXDao.createTable(db, ifNotExists);
    }
    
    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(SQLiteDatabase db, boolean ifExists) {
        ChaoBiaoRWDao.dropTable(db, ifExists);
        ChaoBiaoSJDao.dropTable(db, ifExists);
        ChaoBiaoBZDao.dropTable(db, ifExists);
        ChaoBiaoGJDao.dropTable(db, ifExists);
        ChaoBiaoJLDao.dropTable(db, ifExists);
        HuanBiaoJLDao.dropTable(db, ifExists);
        CiYuXXDao.dropTable(db, ifExists);
        XinXiBGDao.dropTable(db, ifExists);
        FeiYongZKLDao.dropTable(db, ifExists);
        WordsInfoDao.dropTable(db, ifExists);
        DingEJJBLDao.dropTable(db, ifExists);
        FeiYongZCDao.dropTable(db, ifExists);
        ShuiLiangFTXXDao.dropTable(db, ifExists);
        JianHaoMXDao.dropTable(db, ifExists);
        ReXianGDDao.dropTable(db, ifExists);
        JianHaoDao.dropTable(db, ifExists);
        ChaoBiaoRWDao.dropTable(db, ifExists);
        ChaoBiaoSJDao.dropTable(db, ifExists);
        ChaoBiaoZTDao.dropTable(db, ifExists);
        ChaoBiaoZTFLDao.dropTable(db, ifExists);
        DuoMeiTXXDao.dropTable(db, ifExists);
        GuiJiDao.dropTable(db, ifExists);
        NeiFuBZDao.dropTable(db, ifExists);
        ZhuangTaiLXCSDao.dropTable(db, ifExists);
        BIAOKAXXDao.dropTable(db, ifExists);
        DengLuLSDao.dropTable(db, ifExists);
        MetaInfoDao.dropTable(db, ifExists);
        BiaoWuGDDao.dropTable(db, ifExists);
        RenwuXXDao.dropTable(db, ifExists);
        UsersDao.dropTable(db, ifExists);
        WaiFuGDDetailDao.dropTable(db, ifExists);
        WaiFuGDMainDao.dropTable(db, ifExists);
        WaiFuYYDao.dropTable(db, ifExists);
        YanChiBiaoDao.dropTable(db, ifExists);
        JiaoFeiXXDao.dropTable(db, ifExists);
        GongGaoXXDao.dropTable(db, ifExists);
        YuanGongXXDao.dropTable(db, ifExists);
        UserInfoDao.dropTable(db, ifExists);
        JinEXXDao.dropTable(db, ifExists);
        QianFeiXXDao.dropTable(db, ifExists);
    }
    
    public static abstract class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }
        private static SQLiteDatabase openDateBase(Context context, String dbPath) {

            SQLiteDatabase db = context.openOrCreateDatabase(dbPath,
                    Context.MODE_PRIVATE, null);
            return db;
        }

        public static SQLiteDatabase getSQLiteDatabase(Context context) {
            if (db == null){
                File sdDir = Environment.getExternalStorageDirectory();
                File dataDir = new File(sdDir, "sh3h/meterreading/data");
                File dataFile = new File(dataDir, "main.cbj");
                db = openDateBase(context, dataFile.getPath());
            }
            return db;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }
    
    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

    public DaoMaster(SQLiteDatabase db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(ChaoBiaoRWDao.class);
        registerDaoClass(ChaoBiaoSJDao.class);
        registerDaoClass(ChaoBiaoBZDao.class);
        registerDaoClass(ChaoBiaoGJDao.class);
        registerDaoClass(ChaoBiaoJLDao.class);
        registerDaoClass(HuanBiaoJLDao.class);
        registerDaoClass(CiYuXXDao.class);
        registerDaoClass(XinXiBGDao.class);
        registerDaoClass(FeiYongZKLDao.class);
        registerDaoClass(WordsInfoDao.class);
        registerDaoClass(DingEJJBLDao.class);
        registerDaoClass(FeiYongZCDao.class);
        registerDaoClass(ShuiLiangFTXXDao.class);
        registerDaoClass(JianHaoMXDao.class);
        registerDaoClass(ReXianGDDao.class);
        registerDaoClass(JianHaoDao.class);
        registerDaoClass(ChaoBiaoRWDao.class);
        registerDaoClass(ChaoBiaoSJDao.class);
        registerDaoClass(ChaoBiaoZTDao.class);
        registerDaoClass(ChaoBiaoZTFLDao.class);
        registerDaoClass(DuoMeiTXXDao.class);
        registerDaoClass(GuiJiDao.class);
        registerDaoClass(NeiFuBZDao.class);
        registerDaoClass(ZhuangTaiLXCSDao.class);
        registerDaoClass(BIAOKAXXDao.class);
        registerDaoClass(DengLuLSDao.class);
        registerDaoClass(MetaInfoDao.class);
        registerDaoClass(BiaoWuGDDao.class);
        registerDaoClass(RenwuXXDao.class);
        registerDaoClass(UsersDao.class);
        registerDaoClass(WaiFuGDDetailDao.class);
        registerDaoClass(WaiFuGDMainDao.class);
        registerDaoClass(WaiFuYYDao.class);
        registerDaoClass(YanChiBiaoDao.class);
        registerDaoClass(JiaoFeiXXDao.class);
        registerDaoClass(GongGaoXXDao.class);
        registerDaoClass(YuanGongXXDao.class);
        registerDaoClass(UserInfoDao.class);
        registerDaoClass(JinEXXDao.class);
        registerDaoClass(QianFeiXXDao.class);
    }
    public static SQLiteDatabase getSQLiteDatabase(String path, Context context) {
        if ((path == null) || (context == null)) {
            return null;
        }

        if (db == null) {
            db = context.openOrCreateDatabase(path, Context.MODE_PRIVATE, null);;
        }

        return db;
    }
    
    
    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }
    
    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }
    
}