package com.sh3h.dataprovider.greendaoEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table PDA_USERS.
 */
public class Users {

    private String S_ACCOUNT;
    private String S_USERNAME;
    private String S_ST;
    private Integer I_TYPE;

    public Users() {
    }

    public Users(String S_ACCOUNT, String S_USERNAME, String S_ST, Integer I_TYPE) {
        this.S_ACCOUNT = S_ACCOUNT;
        this.S_USERNAME = S_USERNAME;
        this.S_ST = S_ST;
        this.I_TYPE = I_TYPE;
    }

    public String getS_ACCOUNT() {
        return S_ACCOUNT;
    }

    public void setS_ACCOUNT(String S_ACCOUNT) {
        this.S_ACCOUNT = S_ACCOUNT;
    }

    public String getS_USERNAME() {
        return S_USERNAME;
    }

    public void setS_USERNAME(String S_USERNAME) {
        this.S_USERNAME = S_USERNAME;
    }

    public String getS_ST() {
        return S_ST;
    }

    public void setS_ST(String S_ST) {
        this.S_ST = S_ST;
    }

    public Integer getI_TYPE() {
        return I_TYPE;
    }

    public void setI_TYPE(Integer I_TYPE) {
        this.I_TYPE = I_TYPE;
    }

}