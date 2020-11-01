package com.ataccama.dbviewer.persistence;

import com.ataccama.dbviewer.model.DbDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DbDetailRepository extends CrudRepository<DbDetail, Long> {

    Optional<DbDetail> findByName(String key);

}