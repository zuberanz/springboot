package com.zuberanz.springinception.restfulwebservices.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class TopicDaoService {

    private static List<TopicBean> topics = new ArrayList<>();

    @Autowired
    private TopicRepository topicRepo;

    static{
        topics.add(new TopicBean("java","Concurrency","java multithreading concepts"));
    }

    /*public TopicBean create_topic(TopicBean topic){
        topics.add(topic);
        return topic;
    }*/

    public TopicBean create_topic(TopicBean topic){
        topicRepo.save(topic);
        return topic;
    }

    /*public List<TopicBean> getAllTopics(){
        return topics;
    }*/

    public List<TopicBean> getAllTopics(){
        List<TopicBean> topics = new ArrayList<>();
        Iterator<TopicBean> it = topicRepo.findAll().iterator();
        while(it.hasNext()){
            topics.add(it.next());
        }
        return topics;
    }

    /*public TopicBean getTopic(String id){
        TopicBean topic;
        Optional<TopicBean> result  = topics.stream().filter((p) -> id.equals(p.getTopicID())).findFirst();
        if(result.isPresent()){
            return result.get();
        }else{
            return null;
        }
    }*/

    public TopicBean getTopic(String id){

        Optional<TopicBean> result  = topicRepo.findById(id);
        if(result.isPresent()){
            return result.get();
        }else{
            return null;
        }
    }

   /* public TopicBean updateTopic(String id, TopicBean patch_topic){

        TopicBean topic;
        Optional<TopicBean> result  = topics.stream().filter((p) -> id.equals(p.getTopicID())).findFirst();
        if(result.isPresent()){
             topic  = result.get();
            int index = topics.indexOf(topic);
            topics.set(index,patch_topic);
            return patch_topic;
        }else{
            return null;
        }
    }*/


    public TopicBean updateTopic(String id, TopicBean patch_topic){

        //here it works as update, bcos it looks for primary key in the topic and updates tehe same
        topicRepo.save(patch_topic);
        return patch_topic;

    }


    /*public void deleteTopic(String id){
        TopicBean topic  = topics.stream().filter((p) -> id.equals(p.getTopicID())).findFirst().get();
        topics.remove(topic);

    }*/

    public void deleteTopic(String id){
        topicRepo.deleteById(id);

    }

}
