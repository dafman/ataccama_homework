package com.ataccama.dbviewer.service;

import com.ataccama.dbviewer.dto.ColumnStatisticsResponse;
import com.ataccama.dbviewer.dto.ColumnsResponse;
import com.ataccama.dbviewer.dto.DataPreviewResponse;
import com.ataccama.dbviewer.dto.TablesResponse;
import com.ataccama.dbviewer.persistence.BrowsingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DbBrowsingService {

    @Autowired
    BrowsingRepository browsingRepository;

    public TablesResponse showTables() {
        return browsingRepository.showTables();
    }

    public ColumnsResponse showColumns(String table) {
        return browsingRepository.showColumns(table);
    }

    public ColumnStatisticsResponse getColumnStatistics(String table, String column) {
        return browsingRepository.getColumnStatistics(table, column);
    }

    public DataPreviewResponse getDataPreview(String table) {
        return browsingRepository.getDataPreview(table);
    }
}


