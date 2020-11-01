package com.ataccama.dbviewer.exception;

public class DbViewerException extends RuntimeException {

    private ErrorCode errorCode;

    public DbViewerException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
