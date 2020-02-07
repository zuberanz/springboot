package com.zuberanz.springinception.restfulwebservices.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TopicBean {
    @Id
    private String topicID;
    private String topiName;
    private String topicDesc;


    public TopicBean(){

    }

    public TopicBean(String topicID, String topicName, String topicDesc){
        this.topicID = topicID;
        this.topiName = topicName;
        this.topicDesc = topicDesc;
    }


    public String getTopicID() {
        return topicID;
    }

    public void setTopicID(String topicID) {
        this.topicID = topicID;
    }

    public String getTopiName() {
        return topiName;
    }

    public void setTopiName(String topiName) {
        this.topiName = topiName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }
}
