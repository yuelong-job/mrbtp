package com.zoneland.modules.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/home")
    public String index() {
        return "home";
    }

    @GetMapping("/hello")
    public String index1() {
        return "hello";
    }
}
