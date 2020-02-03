package com.zuberanz.springinception.restfulwebservices.users;


import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<UserBean> users =  new ArrayList<>();
    private static int usersCount = 3;

    static{
        users.add(new UserBean(1,"john",new Date()));
        users.add(new UserBean(2,"smith",new Date()));
        users.add(new UserBean(3,"clarke",new Date()));
    }


    public List<UserBean> findAllUsers(){
        return users;
    }

    public UserBean saveUser(UserBean user){
        if(user.getId() == null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public UserBean finOneUser(int id){
        for(UserBean user : users){
            if(user.getId() ==  id){
                return user;
            }
        }
        return null;
    }

    public void DeleteUser(int id){
        for(UserBean user : users){
            if(user.getId() ==  id){
                users.remove(user);
            }
        }
    }


}
