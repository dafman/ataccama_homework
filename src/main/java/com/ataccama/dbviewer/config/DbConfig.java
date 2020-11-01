package com.ataccama.dbviewer.config;


import com.ataccama.dbviewer.component.DefaultRoutingDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DbConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DataSource getDataSource() {
        DefaultRoutingDataSource routingDataSource = new DefaultRoutingDataSource();
        routingDataSource.setDefaultTargetDataSource(DataSourceBuilder.create().url(url).username(userName).password(password).build());
        routingDataSource.setTargetDataSources(new HashMap<>());
        return routingDataSource;
    }
}