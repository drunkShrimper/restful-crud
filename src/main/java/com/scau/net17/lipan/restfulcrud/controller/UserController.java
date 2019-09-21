package com.scau.net17.lipan.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/user")
@Controller
public class UserController {

    @RequestMapping("/findOne")
    public String findOne(Map<String,String> map){

        map.put("name","zhangsan");

        return "success";
    }
}
