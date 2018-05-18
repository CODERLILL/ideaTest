package com.lhl.service.impl;

import com.lhl.bean.Role;
import com.lhl.mapper.RoleMapper;
import com.lhl.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Role getRoleInfo(int sId) {
        Role role = roleMapper.getRoleInfo(sId);
        return role;

    }
}
