package com.schooldrive.logic.hoursinterval;

import com.schooldrive.logic.utils.ServiceException;

/**
 * Created by Filip on 16.12.2017.
 */
public class HoursIntervalServiceException extends ServiceException {

    public HoursIntervalServiceException(String message) {
        super(message);
    }

    public HoursIntervalServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
