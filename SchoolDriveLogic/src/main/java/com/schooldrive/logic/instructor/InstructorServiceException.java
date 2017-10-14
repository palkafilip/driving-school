package com.schooldrive.logic.instructor;

/**
 * Created by Filip on 12.10.2017.
 */
public class InstructorServiceException extends Exception {

    public InstructorServiceException(String message) {
        super(message);
    }
    public InstructorServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
