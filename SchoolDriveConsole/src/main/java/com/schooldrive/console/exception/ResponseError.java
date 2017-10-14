package com.schooldrive.console.exception;

/**
 * Created by Filip on 14.10.2017.
 */
public class ResponseError {

    private String exceptionType;
    private String exceptionMessage;

    public ResponseError(Throwable e) {
        this.exceptionType = e.getClass().getSimpleName();
        this.exceptionMessage = e.getMessage();
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
