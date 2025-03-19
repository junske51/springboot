package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MonsterController {
// ：因为@ResController 是一个复合注解, 含有@ResponseBody, 所以springboot 底层(springmvc), 在处理
// return "xxx" 时, 会以@ResponseBody 注解进行解析处理, 即返回字符串 "xxx", 而不会使用视图解析器来处理.
// 同学们, 可以试一下, 如果我们把 @RestController 改成 @Controller , 当你访问getMonster() 时, 如果你有 xxx.html就会转发到 xxx.html , 如果没有 xxx.html , 就会报 404
// 提示: 在测试时, 讲 xxx.html 放在 main\resources\public\xxx.html 进行测试, 并在application.yml 配置视图解析器
    //等价的写法
    //@RequestMapping(value = "/monster",method = RequestMethod.GET)
    @GetMapping("/monster")
        public String getMonster(){
            return "get-查询";
        }
    @PostMapping("/monster")
        public String postMonster(){
            return "post-保存";
        }
    @PutMapping("/monster")
        public String delMonster() {
        return "del-删除";
    }
    @RequestMapping("/go")
    public String go(){
        return "hello";//先看Controller内有没有/hello，没有再看视图解析器hello.html
        }
    }

