package com.lhl.mapper;

import com.lhl.bean.User;


public interface TestMapper {
    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getUserById(Integer id);

}
