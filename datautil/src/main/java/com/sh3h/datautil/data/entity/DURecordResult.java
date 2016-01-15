package com.sh3h.datautil.data.entity;


import java.util.List;

public class DURecordResult extends DUResponse {
    private List<DURecord> duRecordList;

    public DURecordResult() {
        duRecordList = null;
    }

    public List<DURecord> getDuRecordList() {
        return duRecordList;
    }

    public void setDuRecordList(List<DURecord> duRecordList) {
        this.duRecordList = duRecordList;
    }
}
