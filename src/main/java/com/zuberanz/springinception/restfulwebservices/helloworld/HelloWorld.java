package com.zuberanz.springinception.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class   HelloWorld {

    @GetMapping(path = "my-message")
    public String message(){
        return "i am not a beany";
    }


    @GetMapping(path = "my-message-bean")
    public Message_bean hell_worl_service(){

        return new Message_bean("Howdy springy");
    }

    @GetMapping(path = "/path-var/{name}")
    public String Message_PathVar(@PathVariable String name){
        return String.format(" Howdy springy ur-name-> %s",name);
    }


}
