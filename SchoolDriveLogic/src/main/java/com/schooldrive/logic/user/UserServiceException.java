package com.schooldrive.logic.user;

import com.schooldrive.logic.utils.ServiceException;

/**
 * Created by Filip on 12.10.2017.
 */
public class UserServiceException extends ServiceException {

    public UserServiceException(String message) {
        super(message);
    }

    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
