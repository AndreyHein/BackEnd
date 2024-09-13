package de.ait.shop42.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<ApiError> exceptionProductNotFoundHandler(CustomerNotFound e) {
        ApiError apiError = new ApiError("Customer not found", HttpStatus.MULTI_STATUS);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
