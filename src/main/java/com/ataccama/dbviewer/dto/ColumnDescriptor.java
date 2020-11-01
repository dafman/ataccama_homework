package com.ataccama.dbviewer.dto;

public class ColumnDescriptor {

    private String field;
    private String type;
    private String collation;
    private String nullAllowed;
    private String key;
    private String defaultValue;
    private String extra;
    private String privileges;
    private String comment;

    public ColumnDescriptor(String field, String type, String collation, String nullAllowed, String key, String defaultValue, String extra, String privileges, String comment) {
        this.field = field;
        this.type = type;
        this.collation = collation;
        this.nullAllowed = nullAllowed;
        this.key = key;
        this.defaultValue = defaultValue;
        this.extra = extra;
        this.privileges = privileges;
        this.comment = comment;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCollation() {
        return collation;
    }

    public void setCollation(String collation) {
        this.collation = collation;
    }

    public String getNullAllowed() {
        return nullAllowed;
    }

    public void setNullAllowed(String nullAllowed) {
        this.nullAllowed = nullAllowed;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
