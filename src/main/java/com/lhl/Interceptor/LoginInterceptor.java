package com.lhl.Interceptor;

import com.lhl.bean.User;
import com.lhl.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录拦截器
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserServiceImpl service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        String url = request.getRequestURI();
        String userName = request.getParameter("userName");
        User user = service.login(userName);
        System.out.println(user);
        if(user!=null){
            return true;
        }else {
            //request.getRequestDispatcher("/user/error").forward(request,response);
            //response.sendRedirect("/user/error");
            return false;
        }
       //return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }
}
