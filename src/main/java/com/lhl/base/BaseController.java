package com.lhl.base;

import com.lhl.base.response.ResponseBody;
import com.lhl.base.response.ResponseHead;
import com.lhl.base.response.ResponseSatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @version V1.0
 * @Title: BaseController.java <br>
 * @Package 包名 <br>
 * @Description: (所有controller的基类,默认失败) <br>
 * @author: 路逸冰(Allen) <br>
 * @date: 时间 <br>
 */
public class BaseController {
    public ResponseHead createResponse(){
        //默认响应头
        ResponseHead responseHead = new ResponseHead();
        //默认响应体
        ResponseBody responseBody = new ResponseBody();
        responseHead.setCode(ResponseSatus.INTERNAL_SERVER_ERROR.getValue());
        responseHead.setMessage(ResponseSatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        responseHead.setInterfaceStatus(ResponseSatus.INTERFACE_LOCK.getReasonPhrase());
        responseBody.setStatus(ResponseSatus.ERROR_REQUEST.getValue());
        responseBody.setMessage(ResponseSatus.ERROR_REQUEST.getReasonPhrase());
        responseBody.setData(ResponseSatus.ERROR_DATA.getReasonPhrase());
        responseHead.setResponse(responseBody);
        return responseHead;
    }
}
