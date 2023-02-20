package com.springsecurity2.Spring_security2.controller;

import com.springsecurity2.Spring_security2.model.User;
import com.springsecurity2.Spring_security2.services.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/register")
public class RegisterUserController {

    @Autowired
    private RegisterUserService registerUserService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        String str = registerUserService.RegisterUser(user);
        if(str.equalsIgnoreCase("user id or email already exists")) {
             return new ResponseEntity<String>("id or mail already exists", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("user register successfully",HttpStatus.OK);
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable("id") Integer id) {
        String str = registerUserService.updateUser(user,id);
        if(str.equalsIgnoreCase("data not found")) {
            return new ResponseEntity<String>("no user found ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("user data updated sccessfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id) {
        User user = registerUserService.deleteUser(id);
        if(user==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(user));
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        User user = registerUserService.getUserById(id);
        if(user==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(user));
    }


}
