package com.sh3h.dataprovider.greendaoDao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.QueryBuilder;

import com.sh3h.dataprovider.greendaoEntity.MetaInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table META_INFO.
*/
public class MetaInfoDao extends AbstractDao<MetaInfo, Void> {

    public static final String TABLENAME = "META_INFO";

    /**
     * Properties of entity MetaInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property I_BanBenH = new Property(0, Integer.class, "I_BanBenH", false, "I_BANBENH");
        public final static Property S_ChuangJianZ = new Property(1, String.class, "S_ChuangJianZ", false, "S_CHUANGJIANZ");
        public final static Property D_ChuangJianSJ = new Property(2, int.class, "D_ChuangJianSJ", false, "D_CHUANGJIANSJ");
        public final static Property S_ChaoBiaoJiBH = new Property(3, String.class, "S_ChaoBiaoJiBH", false, "S_CHAOBIAOJIBH");
        public final static Property S_ChaoBiaoYBH = new Property(4, String.class, "S_ChaoBiaoYBH", false, "S_CHAOBIAOYBH");
        public final static Property S_ChaoBiaoYXM = new Property(5, String.class, "S_ChaoBiaoYXM", false, "S_CHAOBIAOYXM");
        public final static Property S_MIMA = new Property(6, String.class, "S_MIMA", false, "S_MIMA");
    };


    public MetaInfoDao(DaoConfig config) {
        super(config);
    }
    
    public MetaInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'META_INFO' (" + //
                "'I_BANBENH' INTEGER," + // 0: I_BanBenH
                "'S_CHUANGJIANZ' TEXT," + // 1: S_ChuangJianZ
                "'D_CHUANGJIANSJ' INTEGER NOT NULL ," + // 2: D_ChuangJianSJ
                "'S_CHAOBIAOJIBH' TEXT NOT NULL ," + // 3: S_ChaoBiaoJiBH
                "'S_CHAOBIAOYBH' TEXT NOT NULL ," + // 4: S_ChaoBiaoYBH
                "'S_CHAOBIAOYXM' TEXT," + // 5: S_ChaoBiaoYXM
                "'S_MIMA' TEXT);"); // 6: S_MIMA
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'META_INFO'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, MetaInfo entity) {
        stmt.clearBindings();
 
        Integer I_BanBenH = entity.getI_BanBenH();
        if (I_BanBenH != null) {
            stmt.bindLong(1, I_BanBenH);
        }
 
        String S_ChuangJianZ = entity.getS_ChuangJianZ();
        if (S_ChuangJianZ != null) {
            stmt.bindString(2, S_ChuangJianZ);
        }
        stmt.bindLong(3, entity.getD_ChuangJianSJ());
        stmt.bindString(4, entity.getS_ChaoBiaoJiBH());
        stmt.bindString(5, entity.getS_ChaoBiaoYBH());
 
        String S_ChaoBiaoYXM = entity.getS_ChaoBiaoYXM();
        if (S_ChaoBiaoYXM != null) {
            stmt.bindString(6, S_ChaoBiaoYXM);
        }
 
        String S_MIMA = entity.getS_MIMA();
        if (S_MIMA != null) {
            stmt.bindString(7, S_MIMA);
        }
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public MetaInfo readEntity(Cursor cursor, int offset) {
        MetaInfo entity = new MetaInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getInt(offset + 0), // I_BanBenH
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // S_ChuangJianZ
            cursor.getInt(offset + 2), // D_ChuangJianSJ
            cursor.getString(offset + 3), // S_ChaoBiaoJiBH
            cursor.getString(offset + 4), // S_ChaoBiaoYBH
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // S_ChaoBiaoYXM
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // S_MIMA
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, MetaInfo entity, int offset) {
        entity.setI_BanBenH(cursor.isNull(offset + 0) ? null : cursor.getInt(offset + 0));
        entity.setS_ChuangJianZ(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setD_ChuangJianSJ(cursor.getInt(offset + 2));
        entity.setS_ChaoBiaoJiBH(cursor.getString(offset + 3));
        entity.setS_ChaoBiaoYBH(cursor.getString(offset + 4));
        entity.setS_ChaoBiaoYXM(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setS_MIMA(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(MetaInfo entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(MetaInfo entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }

    /**
     * 获取元数据
     *
     *            SQLiteDatabase实例
     * @return MetaInfo实体
     */
    public MetaInfo get(String account) {
        QueryBuilder qb = this.queryBuilder();
        qb.where(Properties.S_ChaoBiaoYBH.eq(account));
        if (qb.list() == null){
            return null;
        }else {
            return (MetaInfo) qb.list().get(0);
        }
    }

    /**
     * 本地认证，通过传入pwd，account判断本地是否存在这个数据，如果存在返回true，否则为false；
     *
     * @param mima
     *            密码
     * @param account
     *            用户名
     * @return boolean值
     */
    public int auth(String mima, String account) {
        QueryBuilder qb = this.queryBuilder();
        qb.where(Properties.S_MIMA.eq(mima), Properties.S_ChaoBiaoYBH.eq(account));
        int count = (int) qb.count();

        if (count > 0) {
            return 1;// 登录成功
        } else {
            QueryBuilder qb2 = this.queryBuilder();
            qb2.where( Properties.S_ChaoBiaoYBH.eq(account));
            if (count > 0) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    /**
     * 接口认证
     *
     * @param account
     *            账号
     * @return boolean
     */
    public boolean authenticationInterface(String account) {
        QueryBuilder qb = this.queryBuilder();
        qb.where(Properties.S_ChaoBiaoYBH.eq(account));
        int count = (int) qb.count();
        return count >= 1;
    }
    
}