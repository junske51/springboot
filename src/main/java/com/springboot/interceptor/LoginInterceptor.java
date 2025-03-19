package com.springboot.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

@Override
//目标方法执行之前
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Object handler) throws Exception{
            String requestUri=httpServletRequest.getRequestURI();
            log.info("拦截请求路径是 "+requestUri);
            //登录检查
    HttpSession session = httpServletRequest.getSession();
    Object loginAdmin = session.getAttribute("loginAdmin");
    if(loginAdmin !=null){
        //放行
        return  true;
    }
    //拦截
    httpServletRequest.setAttribute("msg","重新登陆");
    httpServletRequest.getRequestDispatcher("/").forward(httpServletRequest,httpServletResponse);
    return false;
        }
//目标方法执行完成以后
@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
            log.info("postHandle 执行");
    }
//页面渲染之后
@Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                    Object handler, Exception ex) throws Exception {
    log.info("afterCompletion 执行");
        }

}

