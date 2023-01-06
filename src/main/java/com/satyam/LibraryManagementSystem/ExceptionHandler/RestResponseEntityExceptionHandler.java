package com.satyam.LibraryManagementSystem.ExceptionHandler;

import com.satyam.LibraryManagementSystem.Exception.IdDoesNotExistException;
import com.satyam.LibraryManagementSystem.Model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IdDoesNotExistException.class)
    public ResponseEntity<ErrorMessage> notExist(IdDoesNotExistException exception, WebRequest request){
        ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
