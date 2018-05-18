package com.lhl.utils;

import com.lhl.base.ResponseHttpStatus;
import com.lhl.base.response.ResponseHead;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

/**
 * @version V1.0
 * @Title: IsResponseList.java <br>
 * @Package 包名 <br>
 * @Description: Controller中list数据的通用类 <br>
 * @author: 路逸冰(Allen) <br>
 * @date: 时间 <br>
 */
public class IsResponseList {


    public static ResponseHead isOK(HttpServletResponse response, List list, ResponseHead responseHead) {
        int status = response.getStatus();
        if (status == 200) {
            if (list.size() != 0) {
                return ResponseHttpStatus.successRequest(responseHead, list);
            } else {
                return ResponseHttpStatus.responseStatus(responseHead, 500);
            }
        } else {
            return ResponseHttpStatus.responseStatus(responseHead, status);
        }
    }
}
