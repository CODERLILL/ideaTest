package com.lhl.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.lhl.base.BaseController;
import com.lhl.base.ResponseHttpStatus;
import com.lhl.base.response.ResponseHead;
import com.lhl.bean.User;
import com.lhl.service.UserService;
import com.lhl.utils.IsResponseList;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {
                private User user = null;
                private int status = 0;
                @Resource
                private UserService userService;
    //登录
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    //,produces = "text/plain;charset=utf-8"
    public ResponseHead login1(HttpServletRequest request,HttpServletResponse response,String userName,String passWord) {
        String a = "登录失败";
        String s = "登录成功";
        status =  response.getStatus();
        ResponseHead responseHead = createResponse();
        if(status==200){
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);

                System.out.println("fdsfsd"+userName);
                System.out.println(token);
                try {
                        subject.login(token);
                        return ResponseHttpStatus.successRequest(responseHead,s);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return ResponseHttpStatus.errorRequest(responseHead,a);
                    }
        }else {
                    return ResponseHttpStatus.responseStatus(responseHead, status);
        }
    }



    //登出
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "123";
    }


    //400报错
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    @ResponseBody
    public ResponseHead error(HttpServletRequest request,HttpServletResponse response) {
        //status =  response.getStatus();
        ResponseHead responseHead = createResponse();
        return ResponseHttpStatus.responseStatus(responseHead, 400);
    }



    //未登录
    @RequestMapping(value = "/unlogin", method = RequestMethod.GET)
    @ResponseBody
    public ResponseHead unlogin(HttpServletResponse response) {
        status = response.getStatus();
        ResponseHead responseHead = createResponse();
        if (status==200){
            return ResponseHttpStatus.successRequest(responseHead,"请您先登录");
        }else {
            return ResponseHttpStatus.responseStatus(responseHead,status);
        }
    }



    //认证失败
    @RequestMapping(value = "/angu", method = RequestMethod.GET)
    @ResponseBody
    public ResponseHead angu(HttpServletResponse response) {
        status = response.getStatus();
        ResponseHead responseHead = createResponse();
        if (status==200){
            return ResponseHttpStatus.successRequest(responseHead,"认证失败，没有权限");
        }else {
            return ResponseHttpStatus.responseStatus(responseHead,status);
        }
    }


    private Producer kaptchaProducer = null;
    @Autowired
    public void setCaptchaProducer(Producer kaptchaProducer) {
        this.kaptchaProducer = kaptchaProducer;
    }
    //验证码
    @RequestMapping(value = "/vcode", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = kaptchaProducer.createText();
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        BufferedImage bi = kaptchaProducer.createImage(capText);
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    @RequestMapping(value = "/perm", method = RequestMethod.GET)
    @ResponseBody
    public String admin() {
        return "success";
    }


    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    @ResponseBody
    public String test2() {
        return "success";
    }

    
    //根据id删除
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public ResponseHead deleteByUserId(HttpServletResponse response,@RequestParam("ID") Integer ID) {
        ResponseHead responseHead = createResponse();
        status = response.getStatus();
        if (status == 200) {
            int a = userService.deleteByUserId(ID);
            System.out.println(a);
            if (a==1) {
                return ResponseHttpStatus.successRequest(responseHead, "删除成功");
            } else {
                ResponseHttpStatus.errorRequest(responseHead, "删除失败");
            }
        }
        return ResponseHttpStatus.responseStatus(responseHead, status);
    }

}

