package com.lhl.custom;

import javax.servlet.http.HttpServletResponse;

public class HttpResponseStatus {
    //判断状态返回信息
    public static boolean rStatus(int status){
        if(status == 200){
            return true;
        } else if(status == 500){
            return false;
        } else if(status == 501){
            return false;
        } else{
            return false;
        }
    }
}
