package com.lhl.service.impl;

import com.lhl.bean.User;
import com.lhl.mapper.UserMapper;
import com.lhl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service("userService")
public class UserServiceImpl implements UserService {
   @Resource
    private UserMapper userMapper;
    @Override
    public User login(String username) {
        return userMapper.isUser(username);
    }

    @Override
    public Set<String> getRoles(String username) {
        return userMapper.getRoles(username);
    }

    @Override
    public Set<String> getPermissions(String username) {
        return userMapper.getPermissions(username);
    }

    @Override
    public int deleteByUserId(Integer ID) {
        return userMapper.deleteByUserId(ID);
    }
}
