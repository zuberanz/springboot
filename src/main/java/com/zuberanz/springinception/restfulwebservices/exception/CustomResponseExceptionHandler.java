package com.zuberanz.springinception.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

//@RestController because this class is going to provide the response back when exception occurs
//@ControllerAdvice : because we want this class to be applicable across all controllers in the project. mostly used for exception handling




@ControllerAdvice
@RestController
public class CustomResponseExceptionHandler extends ResponseEntityExceptionHandler {
    //ResponseEntityExceptionHandler imp abstract class, can be extended to provide centralised exception handling across all
    //exception handler method.
    //can be used as base class for our customized excpn handler class

    @ExceptionHandler(TopicNotFoundException.class)
    public final ResponseEntity<Object> handleTopicNotFoundException(Exception ex, WebRequest request)  {

       ExceptionResponse exResp =  new ExceptionResponse(new Date(), ex.getMessage(),request.getDescription(false));

        return new ResponseEntity(exResp, HttpStatus.NOT_FOUND);

    }


}
