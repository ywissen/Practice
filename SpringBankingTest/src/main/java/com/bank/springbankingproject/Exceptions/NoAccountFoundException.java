package com.bank.springbankingproject.Exceptions;

public class NoAccountFoundException extends RuntimeException {

    public NoAccountFoundException(String msg){
        super(msg);
    }
}
