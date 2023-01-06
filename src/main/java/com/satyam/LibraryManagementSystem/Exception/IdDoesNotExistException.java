package com.satyam.LibraryManagementSystem.Exception;

public class IdDoesNotExistException extends Exception{

    public IdDoesNotExistException() {
        super();
    }

    public IdDoesNotExistException(String message) {
        super(message);
    }

    public IdDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdDoesNotExistException(Throwable cause) {
        super(cause);
    }

    protected IdDoesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
