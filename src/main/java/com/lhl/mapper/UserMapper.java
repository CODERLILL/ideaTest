package com.lhl.mapper;

import com.lhl.bean.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserMapper {
    User isUser(String username);
    Set<String> getRoles(String username);
    Set<String> getPermissions(String username);
    int deleteByUserId(Integer ID);

}
