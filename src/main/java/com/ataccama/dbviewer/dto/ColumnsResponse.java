package com.ataccama.dbviewer.dto;

import java.util.List;

public class ColumnsResponse {

    private List<ColumnDescriptor> columns;

    public ColumnsResponse(List<ColumnDescriptor> columns) {
        this.columns = columns;
    }

    public ColumnsResponse() {
    }

    public List<ColumnDescriptor> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnDescriptor> columns) {
        this.columns = columns;
    }
}
