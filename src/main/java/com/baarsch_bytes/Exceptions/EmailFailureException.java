package com.baarsch_bytes.Exceptions;

public class EmailFailureException extends Exception{

    public EmailFailureException(String message){
        super("Email Failed!" + message);
    }

}
