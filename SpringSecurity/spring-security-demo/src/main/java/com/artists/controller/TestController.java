package com.artists.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/testController")
    public String testController(){
        return "Test Controller success";
    }
}
