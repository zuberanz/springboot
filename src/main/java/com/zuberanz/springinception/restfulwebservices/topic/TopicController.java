package com.zuberanz.springinception.restfulwebservices.topic;

import com.zuberanz.springinception.restfulwebservices.exception.ExceptionResponse;
import com.zuberanz.springinception.restfulwebservices.exception.TopicNotFoundException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicDaoService topic_service;



    @PostMapping(path = "/addtopic")
    public TopicBean addanewtopic(@RequestBody  TopicBean topic){

        topic_service.create_topic(topic);

        return topic;
    }

    @GetMapping(path = "/topics")
    public List<TopicBean> getAllTopics(){
        return topic_service.getAllTopics();
    }

    @GetMapping(path = "/gettopic/{id}")
    public TopicBean getTopic(@PathVariable  String id){

        TopicBean topic = topic_service.getTopic(id);
        if(topic == null){
            throw new TopicNotFoundException("topic id - "+id);
        }
        return topic;
    }


    @PutMapping(path = "/updatetopic/{id}")
    public TopicBean updateTopic(@PathVariable String id, @RequestBody  TopicBean topic) throws TopicNotFoundException {
        TopicBean newTopic =  topic_service.updateTopic(id,topic);
        if(newTopic == null){
            throw new TopicNotFoundException("topic id - "+id);
        }

        return newTopic;
    }

}
