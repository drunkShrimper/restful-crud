package com.scau.net17.lipan.restfulcrud.controller;

import com.scau.net17.lipan.restfulcrud.exception.UserNotfoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    //@ResponseBody
    @ExceptionHandler(UserNotfoundException.class)
    public String handleException(Exception e, HttpServletRequest request){

        Map<String,Object> map = new HashMap<>();

        request.setAttribute("javax.servlet.error.status_code",500);

        map.put("code","user not exist");
        map.put("message","找不到用户");

        request.setAttribute("ext",map);

        return "forward:/error";
    }
}
