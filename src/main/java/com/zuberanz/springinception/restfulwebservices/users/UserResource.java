package com.zuberanz.springinception.restfulwebservices.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService  service;

    //retrive all users   // get /users

    @GetMapping(path = "/users")
    public List<UserBean> retrieveAllUsers(){
        return service.findAllUsers();
    }


    //retreive one user   //get /users/{id}
    @GetMapping(path = "/users/{id}")
    public UserBean retrieveObeUser(@PathVariable int id) throws UserNotFoundException {
        UserBean user =  service.finOneUser(id);
        if(user == null){
            throw new UserNotFoundException("id-"+id);
        }
        return user;
    }

    @PostMapping(path="/users")
    public ResponseEntity createUser(@RequestBody UserBean User){
        UserBean user = service.saveUser(User);

        URI location = ServletUriComponentsBuilder.
                                fromCurrentRequest().path("/{id}").
                                        buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PostMapping(path = "/delete/{id}")
    public void DeleteUser(@PathVariable int id){
        service.DeleteUser(id);
    }




}
