package com.springsecurity2.Spring_security2.services;


import com.springsecurity2.Spring_security2.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> list = new ArrayList<>();
    public UserService() {
        list.add(new User("tarun","1234","abc@gmail.com"));
        list.add(new User("sanidhya","12345","sanu@gmail.com"));
    }

    public List<User> getAllUser() {
        return list;
    }
    public User getUser(String uname) {
        return this.list.stream().filter((User)->User.getUserName().equalsIgnoreCase(uname)).findAny().orElse(null);
    }
    public User addUser(User user) {
        list.add(user);
        return user;
    }
}
