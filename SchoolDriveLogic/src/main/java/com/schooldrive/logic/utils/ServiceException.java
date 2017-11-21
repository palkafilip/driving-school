package com.schooldrive.logic.utils;

/**
 * Created by Filip on 04.11.2017.
 */
public class ServiceException extends Exception {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
