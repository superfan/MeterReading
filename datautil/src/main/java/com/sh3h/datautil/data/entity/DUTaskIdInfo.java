package com.sh3h.datautil.data.entity;


public class DUTaskIdInfo extends DURequest {
    private String account;

    public DUTaskIdInfo() {

    }

    public DUTaskIdInfo(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

}
