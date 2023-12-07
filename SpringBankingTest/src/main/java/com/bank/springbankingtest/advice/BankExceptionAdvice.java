package com.bank.springbankingtest.advice;

import com.bank.springbankingtest.Exceptions.NoAccountFoundException;
import com.bank.springbankingtest.error.ErrorClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BankExceptionAdvice {

    @ExceptionHandler(NoAccountFoundException.class)
    public ResponseEntity<ErrorClass> accountNotFound(NoAccountFoundException ex){
        return new ResponseEntity<ErrorClass>(new ErrorClass(ex.getMessage(),"Recode Not Found"), HttpStatus.BAD_REQUEST);
    }
}
