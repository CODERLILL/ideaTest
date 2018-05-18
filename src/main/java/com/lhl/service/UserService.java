package com.lhl.service;

import com.lhl.bean.User;

import java.util.Map;
import java.util.Set;

public interface UserService {
    /**
     *登录
     * */
    User login(String username);
    /**
     *获取角色
     * */
    Set<String> getRoles(String username);
    /**
     *获取权限
     * */
    Set<String> getPermissions(String username);
    /**
     *根据id删除
     * */
    int deleteByUserId(Integer ID);
}
