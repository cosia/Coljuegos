package com.coljuegos.crud.exception;

import jakarta.persistence.EntityNotFoundException;
import org.hibernate.PropertyValueException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException e){
        ApiError err = new ApiError(HttpStatus.NOT_FOUND);
        err.setMessage(e.getMessage());
        return buildResponseEntity(err);
    }

    @ExceptionHandler(PropertyValueException.class)
    protected ResponseEntity<Object> handlePropertyValueException(PropertyValueException e){
        ApiError err = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
        err.setMessage(e.getMessage());
        return buildResponseEntity(err);
    }


    private ResponseEntity<Object> buildResponseEntity(ApiError err) {
        return new ResponseEntity<>(err, err.getStatus());
    }
}
