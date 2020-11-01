package com.ataccama.dbviewer.dto;

import java.util.List;

public class DataPreviewResponse {
    private List<Object[]> resultList;

    public DataPreviewResponse(List<Object[]> resultList) {
        this.resultList = resultList;
    }

    public DataPreviewResponse() {
    }

    public List<Object[]> getResultList() {
        return resultList;
    }

    public void setResultList(List<Object[]> resultList) {
        this.resultList = resultList;
    }
}
