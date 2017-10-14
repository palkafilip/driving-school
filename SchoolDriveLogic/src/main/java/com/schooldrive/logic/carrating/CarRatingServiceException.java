package com.schooldrive.logic.carrating;

/**
 * Created by Filip on 12.10.2017.
 */
public class CarRatingServiceException extends Exception {

    public CarRatingServiceException(String message) {
        super(message);
    }
    public CarRatingServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
