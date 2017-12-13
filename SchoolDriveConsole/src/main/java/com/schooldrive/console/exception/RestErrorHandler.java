package com.schooldrive.console.exception;

import com.schooldrive.logic.utils.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;

/**
 * Created by Filip on 12.10.2017.
 */
@RestControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = Logger.getLogger(RestErrorHandler.class);

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Object handleAccessDeniedException(Throwable e) {
        LOGGER.error(e.getMessage(), e);
        return new ResponseError(e);
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Object handleException(Throwable e) {
        LOGGER.error(e.getMessage(), e);
        return new ResponseError(e);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object handleGlobalException(Throwable e) {
        LOGGER.error(e.getMessage(), e);
        return new ResponseError(e);
    }
}
