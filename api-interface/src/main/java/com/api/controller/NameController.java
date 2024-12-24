package com.api.controller;

import cn.hutool.Hutool;
import com.api.sdk.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/")
public class NameController {

    @GetMapping("/getName")
    public String getNameByGet(String name,  HttpServletRequest request) {
        System.out.println(request.getHeader("xu"));
        return "Get 你的名字是：" + name;
    }

    @PostMapping("/getUser")
    public String getUserByPost(@RequestBody User user, HttpServletRequest request) {
        System.out.println("Post 你的User名字是：" + user.getName());
        return "200";
    }
}
