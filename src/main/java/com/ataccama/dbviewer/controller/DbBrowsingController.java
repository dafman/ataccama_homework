package com.ataccama.dbviewer.controller;

import com.ataccama.dbviewer.dto.*;
import com.ataccama.dbviewer.service.DbBrowsingService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/db/{db}/browse")
public class DbBrowsingController {

    @Autowired
    DbBrowsingService dbBrowsingService;

    @GetMapping(path = "/tables", produces = {MediaType.APPLICATION_JSON_VALUE})
    public TablesResponse showTables(@Parameter(example = "mysql_client2") @PathVariable("db") String db) {
        return dbBrowsingService.showTables();
    }

    @GetMapping(path = "/table/{table}/columns", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ColumnsResponse showColumns(@Parameter(example = "mysql_client2") @PathVariable("db") String db,
                                       @Parameter(example = "MyGuests") @PathVariable("table") String table) {
        return dbBrowsingService.showColumns(table);
    }

    @ResponseBody
    @GetMapping(path = "/table/{table}/column/{column}/column-stats", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ColumnStatisticsResponse columnStats(
            @Parameter(example = "mysql_client2") @PathVariable("db") String db,
            @Parameter(example = "MyGuests") @PathVariable("table") String table,
            @Parameter(example = "id") @PathVariable("column") String column) {
        return dbBrowsingService.getColumnStatistics(table, column);
    }

    @GetMapping(path = "/table/{table}/preview", produces = {MediaType.APPLICATION_JSON_VALUE})
    public DataPreviewResponse dataPreview(
            @Parameter(example = "mysql_client2") @PathVariable("db") String db,
            @Parameter(example = "MyGuests") @PathVariable("table") String table) {
        return dbBrowsingService.getDataPreview(table);
    }

}
