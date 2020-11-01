package com.ataccama.dbviewer.dto;

import java.util.List;

public class TablesResponse {

    private List<String> tables;
    public TablesResponse(List<String> tables) {
        this.tables = tables;
    }

    public List<String> getTables() {
        return tables;
    }

    public void setTables(List<String> tables) {
        this.tables = tables;
    }
}
