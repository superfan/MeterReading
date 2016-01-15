package com.sh3h.datautil.data.entity;


import java.util.List;

public class DUCardResult extends DUResponse {
    private List<DUCard> duCardList;

    public DUCardResult() {
        duCardList = null;
    }

    public List<DUCard> getDuCardList() {
        return duCardList;
    }

    public void setDuCardList(List<DUCard> duCardList) {
        this.duCardList = duCardList;
    }
}
