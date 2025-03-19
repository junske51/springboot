package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RequestController {
    @GetMapping("/log")
    public String login(HttpServletRequest request){
        request.setAttribute("user","ke1e");//向request域中加入属性
        request.getSession().setAttribute("web","127.0.0.1");
        return "forward:/ok";
    }
    @GetMapping("/ok")
    @ResponseBody
    public String ok(HttpServletRequest request, @SessionAttribute(value = "web",required = false) String web){
        System.out.println(web);
        System.out.println(request.getAttribute("user"));
        return "success";
    }
}
