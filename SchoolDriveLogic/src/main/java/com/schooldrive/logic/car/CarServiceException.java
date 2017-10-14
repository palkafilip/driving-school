package com.schooldrive.logic.car;

/**
 * Created by Filip on 12.10.2017.
 */
public class CarServiceException extends  Exception {

    public CarServiceException(String message) {
        super(message);
    }
    public CarServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
