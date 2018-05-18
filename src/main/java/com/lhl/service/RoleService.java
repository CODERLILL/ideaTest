package com.lhl.service;

import com.lhl.base.response.ResponseHead;
import com.lhl.bean.Role;

import javax.servlet.http.HttpServletResponse;

public interface RoleService {
    Role getRoleInfo(int sId);
   // ResponseHead getInfo(HttpServletResponse response,int sId);
}
