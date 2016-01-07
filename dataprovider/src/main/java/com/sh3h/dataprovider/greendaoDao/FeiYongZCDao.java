package com.sh3h.dataprovider.greendaoDao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.QueryBuilder;

import com.sh3h.dataprovider.greendaoEntity.FeiYongZC;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table JG_FeiYongZC.
*/
public class FeiYongZCDao extends AbstractDao<FeiYongZC, Void> {

    public static final String TABLENAME = "JG_FeiYongZC";

    /**
     * Properties of entity FeiYongZC.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ID = new Property(0, int.class, "ID", false, "ID");
        public final static Property I_TIAOJIAH = new Property(1, int.class, "I_TIAOJIAH", false, "I_TIAOJIAH");
        public final static Property I_FEIYONGID = new Property(2, int.class, "I_FEIYONGID", false, "I_FEIYONGID");
        public final static Property S_FEIYONGMC = new Property(3, String.class, "S_FEIYONGMC", false, "S_FEIYONGMC");
        public final static Property N_JIAGE = new Property(4, double.class, "N_JIAGE", false, "N_JIAGE");
        public final static Property I_FEIYONGDLID = new Property(5, int.class, "I_FEIYONGDLID", false, "I_FEIYONGDLID");
        public final static Property N_XISHU = new Property(6, double.class, "N_XISHU", false, "N_XISHU");
    };


    public FeiYongZCDao(DaoConfig config) {
        super(config);
    }
    
    public FeiYongZCDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'JG_FeiYongZC' (" + //
                "'ID' INTEGER NOT NULL ," + // 0: ID
                "'I_TIAOJIAH' INTEGER NOT NULL ," + // 1: I_TIAOJIAH
                "'I_FEIYONGID' INTEGER NOT NULL ," + // 2: I_FEIYONGID
                "'S_FEIYONGMC' TEXT NOT NULL ," + // 3: S_FEIYONGMC
                "'N_JIAGE' REAL," + // 4: N_JIAGE
                "'I_FEIYONGDLID' INTEGER," + // 5: I_FEIYONGDLID
                "'N_XISHU' REAL);"); // 6: N_XISHU
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'JG_FeiYongZC'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, FeiYongZC entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getID());
        stmt.bindLong(2, entity.getI_TIAOJIAH());
        stmt.bindLong(3, entity.getI_FEIYONGID());
        stmt.bindString(4, entity.getS_FEIYONGMC());
 
        double N_JIAGE = entity.getN_JIAGE();
        //if (N_JIAGE != null) {
            stmt.bindDouble(5, N_JIAGE);
        //}
 
        int I_FEIYONGDLID = entity.getI_FEIYONGDLID();
        //if (I_FEIYONGDLID != null) {
            stmt.bindLong(6, I_FEIYONGDLID);
        //}
 
        double N_XISHU = entity.getN_XISHU();
        //if (N_XISHU != null) {
            stmt.bindDouble(7, N_XISHU);
        //}
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public FeiYongZC readEntity(Cursor cursor, int offset) {
        FeiYongZC entity = new FeiYongZC( //
            cursor.getInt(offset), // ID
            cursor.getInt(offset + 1), // I_TIAOJIAH
            cursor.getInt(offset + 2), // I_FEIYONGID
            cursor.getString(offset + 3), // S_FEIYONGMC
            cursor.isNull(offset + 4) ? 0 : cursor.getDouble(offset + 4), // N_JIAGE
            cursor.isNull(offset + 5) ? 0 : cursor.getInt(offset + 5), // I_FEIYONGDLID
            cursor.isNull(offset + 6) ? 0 : cursor.getDouble(offset + 6) // N_XISHU
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, FeiYongZC entity, int offset) {
        entity.setID(cursor.getInt(offset));
        entity.setI_TIAOJIAH(cursor.getInt(offset + 1));
        entity.setI_FEIYONGID(cursor.getInt(offset + 2));
        entity.setS_FEIYONGMC(cursor.getString(offset + 3));
        entity.setN_JIAGE(cursor.isNull(offset + 4) ? 0 : cursor.getDouble(offset + 4));
        entity.setI_FEIYONGDLID(cursor.isNull(offset + 5) ? 0 : cursor.getInt(offset + 5));
        entity.setN_XISHU(cursor.isNull(offset + 6) ? 0 : cursor.getDouble(offset + 6));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(FeiYongZC entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(FeiYongZC entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }

    /**
     * 根据费用组成id查询对应的数据，如果存在则返回true，不存在返回false
     *
     * @param id
     *            费用组成id
     * @return boolean
     */
    public boolean existFeiYongZC(int id) {

        QueryBuilder qb  = this.queryBuilder();
        qb.where(Properties.ID.eq(id));
        return qb.list().size()>0?true:false;

    }
    /**
     * 删除数据库中对应的数据
     *
     */
    public void deleteFeiYongZC() {
        this.deleteAll();
        //this.queryBuilder().buildDelete().executeDeleteWithoutDetachingEntities();
    }

    /**
     * 插入数据到费用组成数据库中
     *
     * @param feiYongZC
     *            抄费用组成数据实体
     */
    public void insertFeiYongZC(FeiYongZC feiYongZC) {

        insertOrReplace(feiYongZC);

    }


}