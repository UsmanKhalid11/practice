package com.sample.securitypractice.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1.0/")
public class HomeController {

@GetMapping("hello")
    public String hello() {
    return "Hello World!";
}
    @GetMapping("home")
    public String home() {
        return "Home allowed for all no auth needed!";
    }
    @GetMapping("admin")
    public String admin() {
        return "Only admin is allowed";
    }
    @GetMapping("user")
    public String user() {
        return "Only user is allowed";
    }

}
