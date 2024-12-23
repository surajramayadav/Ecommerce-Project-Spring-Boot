package com.adminpanel.adminpanel.exception;
import java.util.Date;

import com.adminpanel.adminpanel.exception.ErrorMessage;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@ControllerAdvice
public class GlobalExceptionHandler {

    final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);


    // handling specific exception
    @ExceptionHandler(ConfigDataResourceNotFoundException.class)
    public ResponseEntity<Object> resourceNotFoundHandling(ConfigDataResourceNotFoundException exception, WebRequest request){
        ErrorMessage errorDetails =
                new ErrorMessage(exception.getMessage(),request.getDescription(false),false, new Date());
        logger.error(exception.getMessage());
        return new ResponseEntity<Object>(errorDetails, HttpStatus.NOT_FOUND);
    }

    // handling global exception

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> globalExceptionHandling(Exception exception, WebRequest request){
        ErrorMessage errorDetails =
                new ErrorMessage(exception.getMessage(),request.getDescription(false),false, new Date());
        logger.error(exception.getMessage());
        return new ResponseEntity<Object>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
