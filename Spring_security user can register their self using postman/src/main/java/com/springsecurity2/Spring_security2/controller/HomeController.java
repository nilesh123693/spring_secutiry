package com.springsecurity2.Spring_security2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {

    @GetMapping("/home")
    @ResponseBody
    public String home() {
        return "this is home page";
    }

    @GetMapping("/login")
    @ResponseBody
    public String login() {
        return "this is login page";
    }

    @GetMapping("/register")
    @ResponseBody
    public String register() {
        return "this is register page";
    }
}
