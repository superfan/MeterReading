package com.sh3h.dataprovider.greendaoDao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.DeleteQuery;
import de.greenrobot.dao.query.QueryBuilder;

import com.sh3h.dataprovider.greendaoEntity.GongGaoXX;

import java.util.ArrayList;
import java.util.List;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table SX_GONGGAOXX.
 */
public class GongGaoXXDao extends AbstractDao<GongGaoXX, Void> {

    public static final String TABLENAME = "SX_GONGGAOXX";

    /**
     * Properties of entity GongGaoXX.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property I_GongGaoBH = new Property(0, int.class, "I_GongGaoBH", true, "I_GongGaoBH");
        public final static Property S_GongGaoBT = new Property(1, String.class, "S_GongGaoBT", false, "S_GongGaoBT");
        public final static Property S_GongGaoNR = new Property(2, String.class, "S_GongGaoNR", false, "S_GongGaoNR");
        public final static Property S_FaBuR = new Property(3, String.class, "S_FaBuR", false, "S_FaBuR");
        public final static Property D_FaBuSJ = new Property(4, long.class, "D_FaBuSJ", false, "D_FaBuSJ");
        public final static Property S_JieShouR = new Property(5, String.class, "S_JieShouR", false, "S_JieShouR");
        public final static Property S_BeiZhu = new Property(6, String.class, "S_BeiZhu", false, "S_BeiZhu");
        public final static Property I_SiFouYD = new Property(7, int.class, "I_SiFouYD", false, "I_SiFouYD");
    }

    public GongGaoXXDao(DaoConfig config) {
        super(config);
    }

    public GongGaoXXDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "'SX_GONGGAOXX' (" + //
                "'I_GongGaoBH' INTEGER NOT NULL PRIMARY KEY," + // 0: I_GongGaoBH
                "'S_GongGaoBT' TEXT," + // 1: S_GongGaoBT
                "'S_GongGaoNR' TEXT," + // 2: S_GongGaoNR
                "'S_FaBuR' TEXT," + // 3: S_FaBuR
                "'D_FaBuSJ' INTEGER," + // 4: D_FaBuSJ
                "'S_JieShouR' TEXT," + // 5: S_JieShouR
                "'S_BeiZhu' TEXT," + // 6: S_BeiZhu
                "'I_SiFouYD' INTEGER);"); // 7: I_SiFouYD
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'SX_GONGGAOXX'";
        db.execSQL(sql);
    }

    /**
     * @inheritdoc
     */
    @Override
    protected void bindValues(SQLiteStatement stmt, GongGaoXX entity) {
        stmt.clearBindings();

        int I_GongGaoBH = entity.getI_GongGaoBH();
        //if (I_GongGaoBH != null) {
            stmt.bindLong(1, I_GongGaoBH);
        //}

        String S_GongGaoBT = entity.getS_GongGaoBT();
        if (S_GongGaoBT != null) {
            stmt.bindString(2, S_GongGaoBT);
        }

        String S_GongGaoNR = entity.getS_GongGaoNR();
        if (S_GongGaoNR != null) {
            stmt.bindString(3, S_GongGaoNR);
        }

        String S_FaBuR = entity.getS_FaBuR();
        if (S_FaBuR != null) {
            stmt.bindString(4, S_FaBuR);
        }

        long D_FaBuSJ = entity.getD_FaBuSJ();
        //if (D_FaBuSJ != null) {
            stmt.bindLong(5, D_FaBuSJ);
        //}

        String S_JieShouR = entity.getS_JieShouR();
        if (S_JieShouR != null) {
            stmt.bindString(6, S_JieShouR);
        }

        String S_BeiZhu = entity.getS_BeiZhu();
        if (S_BeiZhu != null) {
            stmt.bindString(7, S_BeiZhu);
        }

        int I_SiFouYD = entity.getI_SiFouYD();
        //if (I_SiFouYD != null) {
            stmt.bindLong(8, I_SiFouYD);
        //}
    }

    /**
     * @inheritdoc
     */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }

    /**
     * @inheritdoc
     */
    @Override
    public GongGaoXX readEntity(Cursor cursor, int offset) {
        GongGaoXX entity = new GongGaoXX( //
                cursor.isNull(offset + 0) ? 0 : cursor.getInt(offset + 0), // I_GongGaoBH
                cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // S_GongGaoBT
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // S_GongGaoNR
                cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // S_FaBuR
                cursor.isNull(offset + 4) ? 0 : cursor.getLong(offset + 4), // D_FaBuSJ
                cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // S_JieShouR
                cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // S_BeiZhu
                cursor.isNull(offset + 7) ? 0 : cursor.getInt(offset + 7) // I_SiFouYD
        );
        return entity;
    }

    /**
     * @inheritdoc
     */
    @Override
    public void readEntity(Cursor cursor, GongGaoXX entity, int offset) {
        entity.setI_GongGaoBH(cursor.isNull(offset + 0) ? 0 : cursor.getInt(offset + 0));
        entity.setS_GongGaoBT(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setS_GongGaoNR(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setS_FaBuR(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setD_FaBuSJ(cursor.isNull(offset + 4) ? 0 : cursor.getLong(offset + 4));
        entity.setS_JieShouR(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setS_BeiZhu(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setI_SiFouYD(cursor.isNull(offset + 7) ? 0 : cursor.getInt(offset + 7));
    }

    /**
     * @inheritdoc
     */
    @Override
    protected Void updateKeyAfterInsert(GongGaoXX entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }

    /**
     * @inheritdoc
     */
    @Override
    public Void getKey(GongGaoXX entity) {
        return null;
    }

    /**
     * @inheritdoc
     */
    @Override
    protected boolean isEntityUpdateable() {
        return true;
    }

    /**
     * 获取所有的公告信息
     *
     * @return List<GongGaoXX>
     */
    public List<GongGaoXX> getGongGaoXXList() {
        return this.loadAll();
    }

    /**
     * 通过公告编号查找对应的公告信息
     *
     * @param gongGaoBH 公告编号
     * @return GongGaoXX
     */
    public GongGaoXX getGongGaoXX(int gongGaoBH) {
        QueryBuilder qb = this.queryBuilder();
        qb.where(Properties.I_GongGaoBH.eq(gongGaoBH));
        if (qb.list() == null) {
            return null;
        }
        GongGaoXX gongGaoXX = (GongGaoXX) qb.list().get(0);
        return gongGaoXX;
    }

    /**
     * 插入公告信息到数据库
     *
     * @param gongGaoXX 公告信息
     * @return boolean
     */
    public boolean insertGongGaoXX(GongGaoXX gongGaoXX) {
        if (this.insertOrReplace(gongGaoXX) == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取当前公告数据中最新时间
     *
     * @return
     */
    public long getGongGaoSJ() {
        QueryBuilder qb = this.queryBuilder();
        qb.orderDesc(Properties.D_FaBuSJ);
        List<GongGaoXX> list = qb.list();
        long time = 0;
        if (list == null) {
            return time;
        } else {
            time = list.get(0).getD_FaBuSJ();
            return time;
        }
    }

    /**
     * 获取未读公告数据条数
     *
     * @return int
     */
    public int getGongGaoXXUnreadCount() {
        QueryBuilder qb = this.queryBuilder();
        qb.where(Properties.I_SiFouYD.eq(0));
        return (int) qb.count();
    }

    /**
     * 修改公告未读信息为已读状态
     *
     * @param gongGaoBH 公告编号
     */
    public void updateCongGaoXXYD(int gongGaoBH) {
        QueryBuilder qb = this.queryBuilder();
        qb.where(Properties.I_GongGaoBH.eq(gongGaoBH));
        if (qb.list() == null) {
            return;
        }
        GongGaoXX gongGaoXX = (GongGaoXX) qb.list().get(0);
        gongGaoXX.setI_SiFouYD(1);
        ;

        QueryBuilder<GongGaoXX> qb2 = this.queryBuilder();
        DeleteQuery<GongGaoXX> bd = qb2.where(Properties.I_GongGaoBH.eq(gongGaoXX)).buildDelete();
        bd.executeDeleteWithoutDetachingEntities();

        this.insertOrReplace(gongGaoXX);
    }

    /**
     * 删除系统公告
     */
    public boolean delectGongGaoXX(int gongGaoBH) {
        QueryBuilder<GongGaoXX> qb = this.queryBuilder();
        qb.where(Properties.I_GongGaoBH.eq(gongGaoBH));
        DeleteQuery<GongGaoXX> bd = qb.where(Properties.I_GongGaoBH.eq(gongGaoBH)).buildDelete();
        bd.executeDeleteWithoutDetachingEntities();
        if (qb.list() != null) {
            return true;
        } else {
            return false;
        }
    }

}
