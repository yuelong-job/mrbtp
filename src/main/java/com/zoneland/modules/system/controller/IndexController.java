package com.zoneland.modules.system.controller;

import com.zoneland.modules.system.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/home")
    public String index() {
        return "home";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        User user = new User();
        user.setUsername("jack");
        user.setPassword("112233");
        model.addAttribute("user", user);
        return "hello";
    }
}
