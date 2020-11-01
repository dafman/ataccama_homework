package com.ataccama.dbviewer.component;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DefaultRoutingDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> CONTEXT = new ThreadLocal<>();

    public void set(String dbName) {
        CONTEXT.set(dbName);
    }

    public void clear() {
        CONTEXT.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return CONTEXT.get();
    }
}
