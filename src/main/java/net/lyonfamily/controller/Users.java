package net.lyonfamily.controller;


import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.ArrayList;

@Controller("/users")
public class Users {
    //List of all users
    private ArrayList<UserRequest> users = new ArrayList<>();

    //Create a hashtable of the users to store name and informataion in a linked list
    //Linked list contians name, phone number, user id
    //User id is generated using an algorithim


    @Get
    public HttpResponse listUsers() {
        return HttpResponse.ok(users.toString());
    }

    @Post
    public HttpResponse newUser(@Body UserRequest userRequest){
        users.add(userRequest);
        return HttpResponse.ok(userRequest.getPhoneNumber());
    }




    @Post(uri = "/group", produces = MediaType.APPLICATION_JSON)
    public String[] createGroup(){
        int index = 0;
        String[] selectedUsers = {};
        //Grab all contacts that were selected

        return selectedUsers;

    }


}
