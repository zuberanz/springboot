package com.zuberanz.springinception.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

public class ExceptionResponse {
    private Date time;
    private String message;
    private String details;


    public ExceptionResponse(Date time, String message, String details) {
        super();
        this.time = time;
        this.message = message;
        this.details = details;
    }

    public Date getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }


}
