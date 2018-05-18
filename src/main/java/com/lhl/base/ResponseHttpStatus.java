package com.lhl.base;

import com.lhl.base.response.ResponseHead;
import com.lhl.base.response.ResponseSatus;

/**
 * @version V1.0
 * @Title: ResponseHttpStatus.java <br>
 * @Package 包名 <br>
 * @Description: (常用请求状态响应的封装) <br>
 * @author: 路逸冰(Allen) <br>
 * @date: 时间 <br>
 */
public class ResponseHttpStatus {
    //服务器报错请求响应封装
    public static ResponseHead responseStatus(ResponseHead responseHead, int status) {
        if (status == 408) {
            responseHead.setCode(ResponseSatus.REQUEST_TIMEOUT.getValue());
            responseHead.setMessage(ResponseSatus.REQUEST_TIMEOUT.getReasonPhrase());
            responseHead.setInterfaceStatus(ResponseSatus.INTERFACE_UNKONWN.getReasonPhrase());
            responseHead.getResponse().setStatus(ResponseSatus.ERROR_REQUEST.getValue());
            responseHead.getResponse().setMessage(ResponseSatus.ERROR_REQUEST.getReasonPhrase());
            responseHead.getResponse().setData(ResponseSatus.ERROR_DATA.getReasonPhrase());
        } else if(status == 500){
            responseHead.setCode(ResponseSatus.INTERNAL_SERVER_ERROR.getValue());
            responseHead.setMessage(ResponseSatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
            responseHead.setInterfaceStatus(ResponseSatus.INTERFACE_UNKONWN.getReasonPhrase());
            responseHead.getResponse().setStatus(ResponseSatus.ERROR_REQUEST.getValue());
            responseHead.getResponse().setMessage(ResponseSatus.ERROR_REQUEST.getReasonPhrase());
            responseHead.getResponse().setData(ResponseSatus.ERROR_DATA.getReasonPhrase());
        } else if(status == 502) {
            responseHead.setCode(ResponseSatus.BAD_GATEWAY.getValue());
            responseHead.setMessage(ResponseSatus.BAD_GATEWAY.getReasonPhrase());
            responseHead.setInterfaceStatus(ResponseSatus.INTERFACE_UNKONWN.getReasonPhrase());
            responseHead.getResponse().setStatus(ResponseSatus.ERROR_REQUEST.getValue());
            responseHead.getResponse().setMessage(ResponseSatus.ERROR_REQUEST.getReasonPhrase());
            responseHead.getResponse().setData(ResponseSatus.ERROR_DATA.getReasonPhrase());
        } else if(status == 503) {
            responseHead.setCode(ResponseSatus.SERVICE_UNAVAILABLE.getValue());
            responseHead.setMessage(ResponseSatus.SERVICE_UNAVAILABLE.getReasonPhrase());
            responseHead.setInterfaceStatus(ResponseSatus.INTERFACE_UNKONWN.getReasonPhrase());
            responseHead.getResponse().setStatus(ResponseSatus.ERROR_REQUEST.getValue());
            responseHead.getResponse().setMessage(ResponseSatus.ERROR_REQUEST.getReasonPhrase());
            responseHead.getResponse().setData(ResponseSatus.ERROR_DATA.getReasonPhrase());
        } else if(status == 504) {
            responseHead.setCode(ResponseSatus.GATEWAY_TIMEOUT.getValue());
            responseHead.setMessage(ResponseSatus.GATEWAY_TIMEOUT.getReasonPhrase());
            responseHead.setInterfaceStatus(ResponseSatus.INTERFACE_UNKONWN.getReasonPhrase());
            responseHead.getResponse().setStatus(ResponseSatus.ERROR_REQUEST.getValue());
            responseHead.getResponse().setMessage(ResponseSatus.ERROR_REQUEST.getReasonPhrase());
            responseHead.getResponse().setData(ResponseSatus.ERROR_DATA.getReasonPhrase());
        } else if(status == 505) {
            responseHead.setCode(ResponseSatus.HTTP_VERSION_NOT_SUPPORTED.getValue());
            responseHead.setMessage(ResponseSatus.HTTP_VERSION_NOT_SUPPORTED.getReasonPhrase());
            responseHead.setInterfaceStatus(ResponseSatus.INTERFACE_UNKONWN.getReasonPhrase());
            responseHead.getResponse().setStatus(ResponseSatus.ERROR_REQUEST.getValue());
            responseHead.getResponse().setMessage(ResponseSatus.ERROR_REQUEST.getReasonPhrase());
            responseHead.getResponse().setData(ResponseSatus.ERROR_DATA.getReasonPhrase());
        } else if(status == 511) {
            responseHead.setCode(ResponseSatus.NETWORK_AUTHENTICATION_REQUIRED.getValue());
            responseHead.setMessage(ResponseSatus.NETWORK_AUTHENTICATION_REQUIRED.getReasonPhrase());
            responseHead.setInterfaceStatus(ResponseSatus.INTERFACE_UNKONWN.getReasonPhrase());
            responseHead.getResponse().setStatus(ResponseSatus.ERROR_REQUEST.getValue());
            responseHead.getResponse().setMessage(ResponseSatus.ERROR_REQUEST.getReasonPhrase());
            responseHead.getResponse().setData(ResponseSatus.ERROR_DATA.getReasonPhrase());
        } else if(status == 010){//参数请求错误或缺少参数
            responseHead.setCode(ResponseSatus.OK.getValue());
            responseHead.setMessage(ResponseSatus.OK.getReasonPhrase());
            responseHead.setInterfaceStatus(ResponseSatus.INTERFACE_USE.getReasonPhrase());
            responseHead.getResponse().setStatus(ResponseSatus.BAD_REQUEST.getValue());
            responseHead.getResponse().setMessage(ResponseSatus.BAD_REQUEST.getReasonPhrase());
            responseHead.getResponse().setData(ResponseSatus.ERROR_DATA.getReasonPhrase());
        } else if(status == 400){
            responseHead.setCode(ResponseSatus.REQUEST_BAD.getValue());
            responseHead.setMessage(ResponseSatus.REQUEST_BAD.getReasonPhrase());
            responseHead.setInterfaceStatus(ResponseSatus.INTERFACE_UNKONWN.getReasonPhrase());
            responseHead.getResponse().setStatus(ResponseSatus.ERROR_REQUEST.getValue());
            responseHead.getResponse().setMessage(ResponseSatus.ERROR_REQUEST.getReasonPhrase());
            responseHead.getResponse().setData(ResponseSatus.ERROR_REQUEST.getReasonPhrase());


        }
        return responseHead;
    }
    //请求成功(200) 参数封装
        public static ResponseHead successRequest(ResponseHead responseHead, Object data){
        responseHead.setCode(ResponseSatus.OK.getValue());
        responseHead.setMessage(ResponseSatus.OK.getReasonPhrase());
        responseHead.setInterfaceStatus(ResponseSatus.INTERFACE_USE.getReasonPhrase());
        responseHead.getResponse().setStatus(ResponseSatus.SUCCESS_PARAMETER_OK.getValue());
        responseHead.getResponse().setMessage(ResponseSatus.SUCCESS_PARAMETER_OK.getReasonPhrase());
        responseHead.getResponse().setData(data);
        return responseHead;
    }

    //请求失败 参数封装
    public static ResponseHead errorRequest(ResponseHead responseHead, Object data){
        responseHead.setCode(ResponseSatus.OK.getValue());
        responseHead.setMessage(ResponseSatus.OK.getReasonPhrase());
        responseHead.setInterfaceStatus(ResponseSatus.INTERFACE_USE.getReasonPhrase());
        responseHead.getResponse().setStatus(ResponseSatus.ERROR_DATA.getValue());
        responseHead.getResponse().setMessage(ResponseSatus.ERROR_DATA.getReasonPhrase());
        responseHead.getResponse().setData(data);
        return responseHead;
    }
}
