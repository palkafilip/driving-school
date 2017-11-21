package com.schooldrive.logic.car;

import com.schooldrive.logic.utils.ServiceException;

/**
 * Created by Filip on 12.10.2017.
 */
public class CarServiceException extends ServiceException {

    public CarServiceException(String message) {
        super(message);
    }
    public CarServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
