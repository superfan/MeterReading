package com.sh3h.dataprovider.greendaoDao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.QueryBuilder;

import com.sh3h.dataprovider.greendaoEntity.UserInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table user.
*/
public class UserInfoDao extends AbstractDao<UserInfo, Void> {

    public static final String TABLENAME = "user";

    /**
     * Properties of entity UserInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property UserName = new Property(0, String.class, "userName", false, "userName");
        public final static Property PassWord = new Property(1, String.class, "PassWord", false, "PassWord");
        public final static Property Account = new Property(2, String.class, "Account", false, "Account");
    };


    public UserInfoDao(DaoConfig config) {
        super(config);
    }
    
    public UserInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'user' (" + //
                "'userName' TEXT," + // 0: userName
                "'PassWord' TEXT," + // 1: PassWord
                "'Account' TEXT);"); // 2: Account
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'user'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, UserInfo entity) {
        stmt.clearBindings();
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(1, userName);
        }
 
        String PassWord = entity.getPassWord();
        if (PassWord != null) {
            stmt.bindString(2, PassWord);
        }
 
        String Account = entity.getAccount();
        if (Account != null) {
            stmt.bindString(3, Account);
        }
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public UserInfo readEntity(Cursor cursor, int offset) {
        UserInfo entity = new UserInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // userName
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // PassWord
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // Account
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, UserInfo entity, int offset) {
        entity.setUserName(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setPassWord(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAccount(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(UserInfo entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(UserInfo entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
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
    public int Login(String mima, String account) {
        QueryBuilder qb = this.queryBuilder();
        qb.where(Properties.PassWord.eq(mima), Properties.Account.eq(account));
        int count = (int) qb.count();
        if (count > 0) {
            return 1;// 登录成功
        } else {
            QueryBuilder qb2 = this.queryBuilder();
            qb2.where( Properties.Account.eq(account));
            if (count > 0) {
                return 0;
            } else {
                return -1;
            }
        }
    }


    /**
     * 返回UserInfo对象
     */
    public UserInfo getUserInfo(String account) {
        QueryBuilder qb = this.queryBuilder();
        qb.where(Properties.Account.eq(account));
        if (qb.list() == null){
            return null;
        }else {
            return (UserInfo) qb.list().get(0);
        }
    }

    
}