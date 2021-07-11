package com.zoneland.modules.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class HelloWorldController {
    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        String hello= "hello springboot";
        log.debug(hello);
        return hello;
    }
}
