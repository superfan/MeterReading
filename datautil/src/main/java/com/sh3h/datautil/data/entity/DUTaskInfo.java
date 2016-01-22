package com.sh3h.datautil.data.entity;


import java.util.List;

public class DUTaskInfo extends DURequest {
    public enum FilterType {
        ALL,
        ONE,
        DELETE,
        YICHAOSHU,
        ZONGSHU
    }

    private FilterType filterType;
    private String account;
    private int taskId;
    private String deviceId;
    private String volume;
    private int number;
    private List<String> taskIdList;
    private List<String> filePathList;

    // only for delete
    public DUTaskInfo(String account,
                      List<String> taskIdList,
                      List<String> filePathList,
                      FilterType filterType,
                      IDUHandler duHandler) {
        this.account = account;
        this.taskIdList = taskIdList;
        this.filePathList = filePathList;
        this.taskId = 0;
        this.volume = null;
        this.filterType = filterType;
        this.duHandler = duHandler;
    }

    public DUTaskInfo(String account,
                      int taskId,
                      String volume,
                      int number,
                      FilterType filterType,
                      IDUHandler duHandler) {
        this.account = account;
        this.taskId = taskId;
        this.volume = volume;
        this.number = number;
        this.filterType = filterType;
        this.duHandler = duHandler;
    }

    public DUTaskInfo() {
        filterType = FilterType.ALL;
        account = null;
        taskId = 0;
        deviceId = null;
        volume = null;
    }

    public DUTaskInfo(String account,
                      int taskId,
                      String deviceId) {
        this.filterType = FilterType.ALL;
        this.account = account;
        this.taskId = taskId;
        this.deviceId = deviceId;
        this.duHandler = null;
        this.volume = null;
    }

    public DUTaskInfo(FilterType filterType,String account,IDUHandler duHandler) {
        this.filterType = filterType;
        this.account = account;
        this.duHandler = duHandler;
    }

    public FilterType getFilterType() {
        return filterType;
    }

    public void setFilterType(FilterType filterType) {
        this.filterType = filterType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<String> getTaskIdList() {
        return taskIdList;
    }

    public void setTaskIdList(List<String> taskIdList) {
        this.taskIdList = taskIdList;
    }

    public List<String> getFilePathList() {
        return filePathList;
    }

    public void setFilePathList(List<String> filePathList) {
        this.filePathList = filePathList;
    }
}
