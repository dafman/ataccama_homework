package com.ataccama.dbviewer.persistence;

import com.ataccama.dbviewer.dto.*;
import com.ataccama.dbviewer.exception.DbViewerException;
import com.ataccama.dbviewer.exception.RestResponseEntityExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;
import java.util.stream.Collectors;

import static com.ataccama.dbviewer.exception.ErrorCode.DBV0003;
import static com.ataccama.dbviewer.exception.ErrorCode.DBV0004;

@Repository
public class BrowsingRepository {

    Logger logger = LoggerFactory.getLogger(BrowsingRepository.class);

    @PersistenceContext
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public TablesResponse showTables() {
        return new TablesResponse(entityManager.createNativeQuery("show tables").getResultList());
    }

    @SuppressWarnings("unchecked")
    public ColumnsResponse showColumns(String table) {
        try {
            List<Object[]> resultList = entityManager.createNativeQuery("show full columns from " + table).getResultList();
            List<ColumnDescriptor> columns = resultList.stream().map(r -> new ColumnDescriptor((String) r[0], (String) r[1], (String) r[2], (String) r[3], (String) r[4],
                    (String) r[5], (String) r[6], (String) r[7], (String) r[8])).
                    collect(Collectors.toList());
            return new ColumnsResponse(columns);
        } catch (PersistenceException e) {
            logger.warn("failed execute shownColumns");
            throw new DbViewerException(DBV0003);
        }
    }

    @SuppressWarnings("unchecked")
    public DataPreviewResponse getDataPreview(String table) {
        try {
            List<Object[]> resultList = entityManager.createNativeQuery("select * from " + table + " limit 10").getResultList();
            return new DataPreviewResponse(resultList);
        } catch (PersistenceException e) {
            throw new DbViewerException(DBV0003);
        }
    }

    public ColumnStatisticsResponse getColumnStatistics(String table, String column) {
        try {
            Object[] result = (Object[]) entityManager.createNativeQuery("select min(" + column + ") as min, max(" + column + ") as max, avg( " + column + ") as avg from " + table).getSingleResult();
            return new ColumnStatisticsResponse(result[0], result[1], result[2]);
        } catch (PersistenceException e) {
            throw new DbViewerException(DBV0004);
        }
    }
}
