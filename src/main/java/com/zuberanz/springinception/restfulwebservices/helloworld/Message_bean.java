package com.zuberanz.springinception.restfulwebservices.helloworld;

public class Message_bean {

    private  String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message_bean{" +
                "message='" + message + '\'' +
                '}';
    }

    public Message_bean(String message) {
        this.message = message;
    }
}
