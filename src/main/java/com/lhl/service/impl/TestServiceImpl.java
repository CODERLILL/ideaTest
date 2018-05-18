package com.lhl.service.impl;

import com.lhl.bean.User;
import com.lhl.mapper.TestMapper;
import com.lhl.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    @CacheEvict(value = { "saveUser"}, allEntries = true)
    public void saveUser(User user) {
        testMapper.saveUser(user);
    }

    @Override
    @Cacheable("getUserById")
    public User getUserById(Integer id) {
        return testMapper.getUserById(id);
    }
}
