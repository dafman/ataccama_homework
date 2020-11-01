package com.ataccama.dbviewer.exception;

public enum ErrorCode {

    DBV0000("unhandled server error"),
    DBV0001("database param was not provided!"),
    DBV0002("given database does not exist!"),
    DBV0003("given table does not exist!"),
    DBV0004("failed to get column stats, given column or table does not exist!"),
    DBV0005("given db detail was not found!"),
    DBV0006("db detail with given id was not found!");

    private final String message;
    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return name();
    }


}
