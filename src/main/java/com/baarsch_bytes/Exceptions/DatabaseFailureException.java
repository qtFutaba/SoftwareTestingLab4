package com.baarsch_bytes.Exceptions;

public class DatabaseFailureException extends Exception{

    public DatabaseFailureException(String message){
        super("Database Failed!" + message);
    }
}
