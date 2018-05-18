package com.lhl.bean;

import java.io.Serializable;

/**
 *角色类
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    private int sid;
    private String  rname;

    public Role() {
    }

    public Role(int sid, String rname) {
        this.sid = sid;
        this.rname = rname;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}
