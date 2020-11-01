package com.ataccama.dbviewer.dto;

public class ColumnStatisticsResponse {
    private Object min;
    private Object max;
    private Object avg;

    public ColumnStatisticsResponse(Object min, Object max, Object avg) {
        this.min = min;
        this.max = max;
        this.avg = avg;
    }

    public Object getMin() {
        return min;
    }

    public void setMin(Object min) {
        this.min = min;
    }

    public Object getMax() {
        return max;
    }

    public void setMax(Object max) {
        this.max = max;
    }

    public Object getAvg() {
        return avg;
    }

    public void setAvg(Object avg) {
        this.avg = avg;
    }

}
