package com.sh3h.datautil.data.entity;

import java.util.List;

/**
 * Created by zhangzhe on 2015/10/14.
 */
public class DUComBinedInfo extends DURequest{

    private DUComBined duComBined;
    private String account;
    private List<String> mCHList;
    private IDUHandler duHandler;

    public DUComBinedInfo(DUComBined duComBined, String account, List<String> mCHList, IDUHandler duHandler) {
        this.duComBined = duComBined;
        this.account = account;
        this.mCHList = mCHList;
        this.duHandler = duHandler;
    }

    public DUComBined getDuComBined() {
        return duComBined;
    }

    public void setDuComBined(DUComBined duComBined) {
        this.duComBined = duComBined;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public IDUHandler getDuHandler() {
        return duHandler;
    }

    @Override
    public void setDuHandler(IDUHandler duHandler) {
        this.duHandler = duHandler;
    }

    public List<String> getmCHList() {
        return mCHList;
    }

    public void setmCHList(List<String> mCHList) {
        this.mCHList = mCHList;
    }
}
