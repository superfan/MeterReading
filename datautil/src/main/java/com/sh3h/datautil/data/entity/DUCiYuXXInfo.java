package com.sh3h.datautil.data.entity;


public class DUCiYuXXInfo extends DURequest {
    public enum FilterType {
        LIANG_GAO_YY,
        LIANG_DI_YY,
        YANCHI_YY
    }

    private FilterType filterType;

    public DUCiYuXXInfo() {
        filterType = FilterType.LIANG_GAO_YY;
    }

    public DUCiYuXXInfo(FilterType filterType,
                        IDUHandler duHandler) {
        this.filterType = filterType;
        this.duHandler = duHandler;
    }

    public FilterType getFilterType() {
        return filterType;
    }

    public void setFilterType(FilterType filterType) {
        this.filterType = filterType;
    }
}
