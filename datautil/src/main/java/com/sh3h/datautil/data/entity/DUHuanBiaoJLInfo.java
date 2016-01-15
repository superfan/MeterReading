package com.sh3h.datautil.data.entity;


public class DUHuanBiaoJLInfo extends DURequest {
    public enum FilterType {
        ALL,
        ONE
    }

    private FilterType filterType;
    private String customerId;
    private String volume;

    private int month;

    public DUHuanBiaoJLInfo(FilterType filterType,
                           String volume,
                           int month,
                           String customerId,
                           IDUHandler duHandler) {
        this.filterType = filterType;
        this.customerId = customerId;
        this.volume=volume;
        this.month=month;
        this.duHandler = duHandler;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public FilterType getFilterType() {
        return filterType;
    }

    public void setFilterType(FilterType filterType) {
        this.filterType = filterType;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
