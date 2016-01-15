package com.sh3h.datautil.data.entity;


public class DUUpdateInfo extends DURequest {
    private int appVersion;
    private int dataVersion;

    public DUUpdateInfo() {
        appVersion = 0;
        dataVersion = 0;
    }

    public DUUpdateInfo(int appVersion,
                        int dataVersion,
                        IDUHandler duHandler) {
        this.appVersion = appVersion;
        this.dataVersion = dataVersion;
        this.duHandler = duHandler;
    }

    public int getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(int appVersion) {
        this.appVersion = appVersion;
    }

    public int getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(int dataVersion) {
        this.dataVersion = dataVersion;
    }
}
