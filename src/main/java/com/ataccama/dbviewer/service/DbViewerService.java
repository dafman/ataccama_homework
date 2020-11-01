package com.ataccama.dbviewer.service;

import com.ataccama.dbviewer.exception.DbViewerException;
import com.ataccama.dbviewer.model.DbDetail;
import com.ataccama.dbviewer.persistence.DbDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.ataccama.dbviewer.exception.ErrorCode.DBV0005;
import static com.ataccama.dbviewer.exception.ErrorCode.DBV0006;

@Service
@Transactional
public class DbViewerService {

    @Autowired
    DbDetailRepository dbDetailRepository;

    public Iterable<DbDetail> findAll() {
        return dbDetailRepository.findAll();
    }

    public DbDetail save(DbDetail detail) {
        return dbDetailRepository.save(detail);
    }

    public DbDetail getDbDetailById(Long id) {
        return dbDetailRepository.findById(id).orElseThrow(() -> new DbViewerException(DBV0005));
    }

    public void deleteById(Long id) {
        dbDetailRepository.deleteById(id);
    }

    public DbDetail updateDbDetail(DbDetail newDetail, Long id) {
        return dbDetailRepository.findById(id).map(detail -> {
            detail.setDatabaseName(newDetail.getDatabaseName());
            detail.setHostname(newDetail.getHostname());
            detail.setName(newDetail.getName());
            detail.setUsername(newDetail.getUsername());
            detail.setPassword(newDetail.getPassword());
            detail.setPort(newDetail.getPort());
            return dbDetailRepository.save(detail);
        }).orElseThrow(() -> new DbViewerException(DBV0006));
    }
}
