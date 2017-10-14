package com.schooldrive.logic.drivebooking;

/**
 * Created by Filip on 12.10.2017.
 */
public class DriveBookingServiceException extends Exception{

    public DriveBookingServiceException(String message) {
        super(message);
    }
    public DriveBookingServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
