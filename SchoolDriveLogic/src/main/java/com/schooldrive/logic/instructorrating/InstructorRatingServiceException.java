package com.schooldrive.logic.instructorrating;

import com.schooldrive.logic.utils.ServiceException;

/**
 * Created by Filip on 12.10.2017.
 */
public class InstructorRatingServiceException extends ServiceException {

    public InstructorRatingServiceException(String message) {
        super(message);
    }
    public InstructorRatingServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
