package com.scau.net17.lipan.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RequestMapping("/user")
@Controller
public class UserController {



    @PostMapping(value = "/login")
    public String login(@RequestParam(name = "username",required = true) String username,
                        @RequestParam(name = "password",required = true)String password,
                        Map<String,Object> map,
                        HttpServletRequest request){

        if (!StringUtils.isEmpty(username) && "123".equals(password)){

            request.getSession().setAttribute("loginUser",username);
            return "redirect:/dashboard.html";
        }else {
            map.put("errorMsg","用户名或密码错误！");
            return "redirect:/index.html";
        }

    }
}
