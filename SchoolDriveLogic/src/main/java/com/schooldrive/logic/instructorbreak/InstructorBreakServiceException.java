package com.schooldrive.logic.instructorbreak;

import com.schooldrive.logic.utils.ServiceException;

/**
 * Created by Filip on 16.12.2017.
 */
public class InstructorBreakServiceException extends ServiceException {

    public InstructorBreakServiceException(String message) {
        super(message);
    }

    public InstructorBreakServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
