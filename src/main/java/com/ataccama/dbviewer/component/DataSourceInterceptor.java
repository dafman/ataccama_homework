package com.ataccama.dbviewer.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.ataccama.dbviewer.exception.DbViewerException;
import com.ataccama.dbviewer.model.DbDetail;
import com.ataccama.dbviewer.persistence.DbDetailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.ataccama.dbviewer.exception.ErrorCode.DBV0001;
import static com.ataccama.dbviewer.exception.ErrorCode.DBV0002;

@Component
public class DataSourceInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(DataSourceInterceptor.class);

    @Autowired
    DefaultRoutingDataSource routingDataSource;

    @Autowired
    DbDetailRepository dbDetailRepository;

    @SuppressWarnings("unchecked")
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) {
        Map<String, String> attributes = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        if (attributes == null || !attributes.containsKey("db")) {
            throw new DbViewerException(DBV0001);
        }
        String key = attributes.get("db");
        Optional<DbDetail> optional = dbDetailRepository.findByName(key);
        if (optional.isEmpty()) {
            throw new DbViewerException(DBV0002);
        }
        routingDataSource.set(key);
        synchronized (this) {
            if (!routingDataSource.getResolvedDataSources().containsKey(key)) {
                    DataSource dataSource = createDataSource(optional.get());
                    Map<Object, Object> newMap = new HashMap<>(routingDataSource.getResolvedDataSources());
                    newMap.put(key, dataSource);
                    routingDataSource.setTargetDataSources(newMap);
                    routingDataSource.afterPropertiesSet();
                    logger.debug("new datasource initialized successfully: " + optional.get().toString());
            }
        }
        logger.info("datasource with key: " + key + " switched successfully");
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        routingDataSource.clear();
    }

    private DataSource createDataSource(DbDetail d) {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://" + d.getHostname() + ":" + d.getPort() + "/" + d.getDatabaseName())
                .username(d.getUsername()).password(d.getPassword()).build();
    }

}
