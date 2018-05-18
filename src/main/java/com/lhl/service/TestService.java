package com.lhl.service;

import com.lhl.bean.User;

public interface TestService {
    /**
     * 保存用户
     * @param
     */
    void saveUser(User user);
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getUserById(Integer id);
}
