package com.scau.net17.lipan.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@Controller
public class UserController {




    @RequestMapping("/findOne")
    public String findOne(Map<String,Object> map){

        String[] users = {"zhang","wnag","zhao"};

        map.put("name","zhangsan");
        map.put("users",users);

        return "success";
    }
}
