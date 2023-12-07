package com.bank.springbankingtest.Exceptions;

public class NoAccountFoundException extends RuntimeException {

    public NoAccountFoundException(String msg){
        super(msg);
    }
}
