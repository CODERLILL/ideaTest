package com.lhl.controller;

import com.lhl.base.BaseController;
import com.lhl.base.ResponseHttpStatus;
import com.lhl.base.response.ResponseHead;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public ResponseHead login(HttpServletResponse response,String userName,String passWord) {
        String a, b, c, d = null;
        a = "登录成功！";
        b = "登录失败！";
        c = "用户名或密码错误！";
        d = "账户被冻结！";
        int status = response.getStatus();
        ResponseHead responseHead = createResponse();
        if (status == 200) {
            Subject subject = SecurityUtils.getSubject();
            //判断用户是否认证
            if (!subject.isAuthenticated()) {
                UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
                //token.setRememberMe(false);
                try {
                    subject.login(token);
                    return ResponseHttpStatus.successRequest(responseHead, a);
                } catch (IncorrectCredentialsException ice) {
                    return ResponseHttpStatus.errorRequest(responseHead, c);
                } catch (LockedAccountException lae) {
                    return ResponseHttpStatus.errorRequest(responseHead, d);
                } catch (AuthenticationException ae) {
                    return ResponseHttpStatus.errorRequest(responseHead, ae.getMessage());
                }
            }else {
                return ResponseHttpStatus.errorRequest(responseHead, "未认证");
            }
        } else {
            return ResponseHttpStatus.responseStatus(responseHead, status);
        }
    }


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public ResponseHead test(HttpServletResponse response) {
        ResponseHead responseHead = createResponse();
        return ResponseHttpStatus.successRequest(responseHead, "测试成功！");
    }
}
