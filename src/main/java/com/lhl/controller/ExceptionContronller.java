package com.lhl.controller;

import com.lhl.base.BaseController;
import com.lhl.base.ResponseHttpStatus;
import com.lhl.base.response.ResponseHead;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
//自定义拦截器异常处理类
@ControllerAdvice
public class ExceptionContronller extends BaseController {

    @ExceptionHandler//(value ={RuntimeException.class})
    @ResponseBody
    public ResponseHead error(HttpServletResponse response,Exception e){
        int status = response.getStatus();
        ResponseHead responseHead = createResponse();
        return ResponseHttpStatus.responseStatus(responseHead,status);
    }

    /*@ExceptionHandler({ArithmeticException.class,IOException.class})
    public ModelAndView TestExceptionHandlerExceptionResolver(Exception ex){
        System.out.println("ControllerAdvice出异常了："+ex);
        ModelAndView model = new ModelAndView("error");
        model.addObject("exception", ex);
        return model;
    }*/
}
