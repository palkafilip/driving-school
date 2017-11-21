package com.schooldrive.logic.carrating;

import com.schooldrive.logic.utils.ServiceException;

/**
 * Created by Filip on 12.10.2017.
 */
public class CarRatingServiceException extends ServiceException {

    public CarRatingServiceException(String message) {
        super(message);
    }
    public CarRatingServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
