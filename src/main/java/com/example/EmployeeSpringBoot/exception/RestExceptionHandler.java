package com.example.EmployeeSpringBoot.exception;

import com.example.EmployeeSpringBoot.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage employeeNotFoundException(EmployeeNotFoundException e){
        ErrorMessage message=new ErrorMessage();
        message.setStatusCode(HttpStatus.NOT_FOUND);
        message.setMessage(e.getMessage());

        return message;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleGenericException(Exception e){
        ErrorMessage message=new ErrorMessage();
        message.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        message.setMessage(e.getMessage());

        return message;
    }
}
