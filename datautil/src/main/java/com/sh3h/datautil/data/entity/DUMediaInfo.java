package com.sh3h.datautil.data.entity;


public class DUMediaInfo extends DURequest {
    public enum OperationType {
        NONE,
        INSERT,
        UPDATE,
        SELECT,
        All,
        DELETE,
        NOT_UPLOADED,
        UPLOADED,
        UPLOADING,
        RE_UPLOADING_ALL,
        DELETE_ALL
    }

    public enum MeterReadingType {
        NORMAL,
        DELAYING,
        ALL
    }

    private OperationType operationType;
    private MeterReadingType meterReadingType;
    private DUMedia duMedia;
    private boolean isLocked;
    private String taskIdsArry;

    public DUMediaInfo() {
        operationType = OperationType.NONE;
        meterReadingType = MeterReadingType.NORMAL;
        duMedia = null;
        isLocked = false;
    }

    public DUMediaInfo(OperationType operationType,
                       DUMedia duMedia,
                       String taskIdsArry,
                       IDUHandler duHandler) {
        this.operationType = operationType;
        this.duMedia = duMedia;
        this.taskIdsArry = taskIdsArry;
        this.duHandler = duHandler;
        this.isLocked = false;
    }

    public DUMediaInfo(OperationType operationType,
                       MeterReadingType meterReadingType,
                       DUMedia duMedia,
                       IDUHandler duHandler) {
        this.operationType = operationType;
        this.meterReadingType = meterReadingType;
        this.duMedia = duMedia;
        this.duHandler = duHandler;
        this.isLocked = false;
    }

    public DUMediaInfo(OperationType operationType,
                       MeterReadingType meterReadingType,
                       DUMedia duMedia,
                       boolean isLocked,
                       IDUHandler duHandler) {
        this.operationType = operationType;
        this.meterReadingType = meterReadingType;
        this.duMedia = duMedia;
        this.duHandler = duHandler;
        this.isLocked = isLocked;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public MeterReadingType getMeterReadingType() {
        return meterReadingType;
    }

    public void setMeterReadingType(MeterReadingType meterReadingType) {
        this.meterReadingType = meterReadingType;
    }

    public DUMedia getDuMedia() {
        return duMedia;
    }

    public void setDuMedia(DUMedia duMedia) {
        this.duMedia = duMedia;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public String getTaskIdsArry() {
        return taskIdsArry;
    }

    public void setTaskIdsArry(String taskIdsArry) {
        this.taskIdsArry = taskIdsArry;
    }
}
