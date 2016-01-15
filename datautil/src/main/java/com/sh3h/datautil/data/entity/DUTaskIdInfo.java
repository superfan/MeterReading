package com.sh3h.datautil.data.entity;


public class DUTaskIdInfo extends DURequest {
    private String account;

    public DUTaskIdInfo() {

    }

    public DUTaskIdInfo(String account, IDUHandler duHandler) {
        this.account = account;
        this.duHandler = duHandler;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

}
