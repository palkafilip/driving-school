package com.schooldrive.logic.instructor;

import com.schooldrive.logic.utils.ServiceException;

/**
 * Created by Filip on 12.10.2017.
 */
public class InstructorServiceException extends ServiceException {

    public InstructorServiceException(String message) {
        super(message);
    }
    public InstructorServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
