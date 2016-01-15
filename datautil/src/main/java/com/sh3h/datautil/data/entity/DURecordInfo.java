package com.sh3h.datautil.data.entity;


import java.util.List;

public class DURecordInfo extends DURequest {
    public enum FilterType {
        NONE,
        ALL,
        UNFINISHING,
        FINISHING,
        SEARCH,
        ONE,
        PREVIOUS_ONE,
        NEXT_UNFINISHED_ONE_WITH_CENEIXH,
        NEXT_ONE,
        UPDATING_ALL,
        UPDATING_ONE,
        NOT_UPLOADED,
        UPLOADING,
        RE_UPDATING_ALL,
        ALL_NO_CONDITION,
        DELETE_ALL,
        DELETE_ONE
    }

    private String account;
    private int taskId;
    private String volume;
    private FilterType filterType;
    private String key;
    private String customerId;
    private long orderNumber;

    private List<DURecord> duRecordList;
    private String deviceId;
    private boolean isLocked;
    private boolean isAdjustingSequence;

    private String taskIdsArr;

    public DURecordInfo() {
        account = null;
        taskId = 0;
        volume = null;
        filterType = FilterType.NONE;
        key = null;
        customerId = null;
        orderNumber = 0;
        duRecordList = null;
        deviceId = null;
        isLocked = false;
        isAdjustingSequence = false;
    }

    public  DURecordInfo(FilterType filterType,
                         String account,
                         String taskIdsArr,
                         IDUHandler duHandler) {
        this.filterType = filterType;
        this.account = account;
        this.taskIdsArr = taskIdsArr;
        this.duHandler = duHandler;
    }

    // for server
    public DURecordInfo(int taskId, IDUHandler duHandler) {
        this.account = null;
        this.taskId = taskId;
        this.volume = null;
        this.filterType = FilterType.NONE;
        this.key = null;
        this.duHandler = duHandler;
        this.customerId = null;
        this.orderNumber = 0;
        this.duRecordList = null;
        this.deviceId = null;
        this.isLocked = false;
        this.isAdjustingSequence = false;
    }

    // for local
    public DURecordInfo(String account,
                        int taskId,
                        String volume,
                        String customerId,
                        FilterType filterType,
                        IDUHandler duHandler) {
        this.account = account;
        this.taskId = taskId;
        this.volume = volume;
        this.filterType = filterType;
        this.duHandler = duHandler;
        this.customerId = customerId;
    }

    // for local
    public DURecordInfo(String account,
                        int taskId,
                        String volume,
                        FilterType filterType,
                        boolean isLocked,
                        IDUHandler duHandler) {
        this.account = account;
        this.taskId = taskId;
        this.volume = volume;
        this.filterType = filterType;
        this.key = null;
        this.duHandler = duHandler;
        this.customerId = null;
        this.orderNumber = 0;
        this.duRecordList = null;
        this.deviceId = null;
        this.isLocked = isLocked;
        this.isAdjustingSequence = false;
    }

    // for local of searching
    public DURecordInfo(String account,
                        int taskId,
                        String volume,
                        FilterType filterType,
                        String key,
                        IDUHandler duHandler) {
        this.account = account;
        this.taskId = taskId;
        this.volume = volume;
        this.filterType = filterType;
        this.key = key;
        this.duHandler = duHandler;
        this.customerId = null;
        this.orderNumber = 0;
        this.duRecordList = null;
        this.deviceId = null;
        this.isLocked = false;
        this.isAdjustingSequence = false;
    }

    // for one record
    public DURecordInfo(String account,
                        int taskId,
                        String volume,
                        FilterType filterType,
                        String customerId,
                        long orderNumber,
                        IDUHandler duHandler) {
        this.account = account;
        this.taskId = taskId;
        this.volume = volume;
        this.filterType = filterType;
        this.key = null;
        this.customerId = customerId;
        this.orderNumber = orderNumber;
        this.duHandler = duHandler;
        this.duRecordList = null;
        this.deviceId = null;
        this.isLocked = false;
        this.isAdjustingSequence = false;
    }

    // for updating records
    public DURecordInfo(FilterType filterType,
                        List<DURecord> duRecordList,
                        boolean isAdjustingSequence,
                        IDUHandler duHandler) {
        this.filterType = filterType;
        this.duRecordList = duRecordList;
        this.duHandler = duHandler;
        this.deviceId = null;
        this.isLocked = false;
        this.isAdjustingSequence = isAdjustingSequence;
    }

    // for uploading one record
    public DURecordInfo(String account,
                        int taskId,
                        String deviceId,
                        FilterType filterType,
                        List<DURecord> duRecordList,
                        IDUHandler duHandler) {
        this.account = account;
        this.taskId = taskId;
        this.deviceId = deviceId;
        this.filterType = filterType;
        this.duRecordList = duRecordList;
        this.duHandler = duHandler;
        this.isLocked = false;
        this.isAdjustingSequence = false;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public FilterType getFilterType() {
        return filterType;
    }

    public void setFilterType(FilterType filterType) {
        this.filterType = filterType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<DURecord> getDuRecordList() {
        return duRecordList;
    }

    public void setDuRecordList(List<DURecord> duRecordList) {
        this.duRecordList = duRecordList;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public boolean isAdjustingSequence() {
        return isAdjustingSequence;
    }

    public void setIsAdjustingSequence(boolean isAdjustingSequence) {
        this.isAdjustingSequence = isAdjustingSequence;
    }

    public String getTaskIdsArr() {
        return taskIdsArr;
    }

    public void setTaskIdsArr(String taskIdsArr) {
        this.taskIdsArr = taskIdsArr;
    }
}
