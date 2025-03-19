package com.springboot.controller;

import com.springboot.bean.Monster;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterController {
    @GetMapping("/monster/{id}/{name}")
    public String pathVariable(@PathVariable("id") Integer id, @PathVariable("name") String name, @PathVariable Map<String,String> map){
        System.out.println(id);
        System.out.println(name);
        System.out.println(map);
        return "success";
    }
//    请求http的host信息
    @GetMapping("/requestHeader")
    public String requestHeader(@RequestHeader("Host") String host,@RequestHeader Map<String,String> header){
        System.out.println(host);
        System.out.println(header);
        return "good";
    }
    @GetMapping("/hi")
    public String hi(@RequestParam("name") String name, @RequestParam("fruit") List<String> fruits,@RequestParam Map<String,String> all){
        System.out.println(name);
        System.out.println(fruits);
        System.out.println(all);
        return "ke1e";
    }
    @GetMapping("/cookie")
//    @CookieValue("cookie_key") String cookie_value表示接收名字为cookie_key的cookie
//    如果接收的是String，则接受的是对应的value；如果是Cookie，则接收封装好的cookie
    public String cookie(@CookieValue(value = "cookie_key",required = false) String cookie_value, @CookieValue(value = "username",required = false)Cookie cookie){
        System.out.println(cookie_value);
        System.out.println(cookie);
        return "yes";
    }
    @PostMapping("/save")
        public String postMethod(@RequestBody String conent){
            System.out.println(conent);
            return "hhh";
        }
    @PostMapping("/savemonster")
    public String saveMonster(Monster monster){
        System.out.println("monster= " + monster);
        return "success";
    }

}
