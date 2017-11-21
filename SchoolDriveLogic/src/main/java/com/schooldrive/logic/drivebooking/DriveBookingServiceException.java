package com.schooldrive.logic.drivebooking;

import com.schooldrive.logic.utils.ServiceException;

/**
 * Created by Filip on 12.10.2017.
 */
public class DriveBookingServiceException extends ServiceException {

    public DriveBookingServiceException(String message) {
        super(message);
    }
    public DriveBookingServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
