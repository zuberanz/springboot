package com.zuberanz.springinception.restfulwebservices.users;

import java.util.Date;

public class UserBean {

    private  Integer id;
    private  Date birthDay;
    private  String name;


    @Override
    public String toString() {
        return "UserBean{" +
                "birthDay=" + birthDay +
                ", name='" + name + '\'' +
                '}';
    }

    public UserBean(Integer id, String name, Date birthDay){
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
    }

    public  Integer getId() {
        return id;
    }

    public  void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
