package com.springsecurity2.Spring_security2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("/signin")
    public String login() {
        return "login";
    }
    @GetMapping("/welcome")
    @ResponseBody
    public String welcome() {
        return "<h1>welcome to our page</h1>";
    }
}
