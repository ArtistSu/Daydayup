package com.artists.controller;

import com.artists.domain.ResponseResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
//    @PreAuthorize("hasAuthority('system/dept/index')")
//    @PreAuthorize("hasAnyAuthority('system/dept/index')")
//    @PreAuthorize("hasRole('ROLE_system/dept/index')")
    @PreAuthorize("@ex.hasAuthority('system/dept/index')")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/testCors")
    public ResponseResult testCors() {
        return new ResponseResult(200, "testCors");
    }
}
