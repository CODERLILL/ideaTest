package com.lhl.base.response;

import java.io.Serializable;

/**
 * @version V1.0
 * @Title: ResponseBody.java <br>
 * @Package 包名 <br>
 * @Description: (响应body体的封装类) <br>
 * @author: 路逸冰(Allen) <br>
 * @date: 时间 <br>
 */
public class ResponseBody implements Serializable{
    private String status;
    private String message;
    private Object data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
