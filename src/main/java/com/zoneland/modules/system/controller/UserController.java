package com.zoneland.modules.system.controller;

import com.zoneland.common.utils.JsonUtils;
import com.zoneland.modules.system.entity.User;
import com.zoneland.modules.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private IUserService userService;

    @GetMapping("/list")
    public String list(HttpServletRequest request) {
        List<User> list = userService.list();

        return JsonUtils.toString(list);
    }
}
