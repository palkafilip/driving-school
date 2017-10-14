package com.schooldrive.logic.user;

/**
 * Created by Filip on 12.10.2017.
 */
public class UserServiceException extends Exception {

    public UserServiceException(String message) {
        super(message);
    }

    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
