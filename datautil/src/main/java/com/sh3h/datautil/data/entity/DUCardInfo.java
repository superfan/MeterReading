package com.sh3h.datautil.data.entity;


import java.util.List;

public class DUCardInfo extends DURequest {
    /**
     * ALL_NO_CONDITION 无条件获取所有本地表卡信息
     */
    public enum FilterType {
        NONE,
        SEARCHING_ALL,
        SEARCHING_ONE,
        UPDATING_ALL,
        ALL_NO_CONDITION
    }

    private FilterType filterType;
    private String volume;
    private String customerId;

    private List<DUCard> duCardList;

    public DUCardInfo() {
        filterType = FilterType.NONE;
        volume = null;
        customerId = null;
        duCardList = null;
    }

    public DUCardInfo(String volume,FilterType filterType,IDUHandler duHandler) {
        this.filterType = filterType;
        this.duHandler = duHandler;
        this.volume = volume;
    }

    public DUCardInfo(String volume, IDUHandler duHandler) {
        this.filterType = FilterType.SEARCHING_ALL;
        this.volume = volume;
        this.customerId = null;
        this.duHandler = duHandler;
        this.duCardList = duCardList;
    }

    public DUCardInfo(String volume,
                      String customerId,
                      IDUHandler duHandler) {
        this.filterType = FilterType.SEARCHING_ONE;
        this.volume = volume;
        this.customerId = customerId;
        this.duHandler = duHandler;
        this.duCardList = null;
    }

    public DUCardInfo(List<DUCard> duCardList,
                      IDUHandler duHandler) {
        this.filterType = FilterType.UPDATING_ALL;
        this.volume = null;
        this.customerId = null;
        this.duCardList = duCardList;
        this.duHandler = duHandler;
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

    public FilterType getFilterType() {
        return filterType;
    }

    public void setFilterType(FilterType filterType) {
        this.filterType = filterType;
    }

    public List<DUCard> getDuCardList() {
        return duCardList;
    }

    public void setDuCardList(List<DUCard> duCardList) {
        this.duCardList = duCardList;
    }
}
