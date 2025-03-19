package com.springboot.controller;
import java.util.ArrayList;

import com.springboot.bean.Admin;
import com.springboot.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
@Slf4j
@Controller
public class AdminController {
    @PostMapping("/login")
    public String login(Admin admin, HttpSession httpSession, Model model) { //RedirectAttributes
        if (StringUtils.hasLength(admin.getName()) && "666666".equals(admin.getPassword())) {
//把登陆成功的管理员保存起来
            httpSession.setAttribute("loginAdmin", admin);
//这里不用 return "manage.html" 转发 为了防止登录成功后，刷新页面会登录表单重复提交
//登录成功重定向到 manage.html; 重定向防止表单重复提交
            return "redirect:/manage.html";
        } else {
            model.addAttribute("msg", "账号/密码错误");
//转发到登录页面
            return "login";
        }
    }
    @GetMapping("/manage.html")
    public  String MainPage(HttpSession httpSession, Model model){
        //有了拦截器, 不需再使用 sessoin 验证
        log.info("执行 mainPage()");
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "关羽~", "666666", 20, "gy@sohu.com"));
        users.add(new User(2, "张飞", "666666", 30, "zf@sohu.com"));
        users.add(new User(3, "赵云", "666666", 22, "zy@sohu.com"));
        users.add(new User(4, "马超", "666666", 28, "mc@sohu.com"));
        users.add(new User(5, "黄忠", "666666", 50, "hz@sohu.com"));
        model.addAttribute("users", users);
        return "manage";
    }
}
