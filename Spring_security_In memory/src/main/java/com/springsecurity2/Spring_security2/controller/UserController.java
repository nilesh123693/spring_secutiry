package com.springsecurity2.Spring_security2.controller;

import com.springsecurity2.Spring_security2.model.User;
import com.springsecurity2.Spring_security2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return userService.getUser(username);
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
