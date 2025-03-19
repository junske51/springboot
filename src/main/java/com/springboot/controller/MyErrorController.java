package com.springboot.controller;

import com.springboot.exception.AccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyErrorController {
    @GetMapping("/err")
    public String err(){
        int i=10/0;
        return "manage";
    }
    @PostMapping("/err2")
    public String err2(){
        return "manage";
    }
    @PostMapping("/err3")
    public String err3(String name){
        if(!"tom".equals(name)){
            throw new AccessException();
        }
        return "manage";
    }
    }
