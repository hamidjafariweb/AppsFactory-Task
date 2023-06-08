package com.appsfactory.calculation.common.exception;

import com.appsfactory.calculation.common.exception.CalculationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionHelper {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleInvalidInputException(CalculationException ex) {
        return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
