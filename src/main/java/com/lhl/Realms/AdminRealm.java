package com.lhl.Realms;

import com.lhl.bean.User;
import com.lhl.service.impl.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

public class AdminRealm extends AuthorizingRealm {
    @Resource//暂时用此service代替
    private UserServiceImpl userService;
    @Override//授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.setRoles(userService.getRoles(username));
        info.setStringPermissions(userService.getPermissions(username));
        return info;
        /*SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        // 根据用户ID查询角色（role），放入到Authorization里。
        Set<String> roles = new HashSet<String>(); // 添加用户角色
        roles.add("超级管理员");
        info.setRoles(roles);
        // 根据用户ID查询权限（permission），放入到Authorization里。
        Set<String> permissions = new HashSet<String>(); // 添加权限
        permissions.add("1");
        info.setStringPermissions(permissions);
        return info;*/
    }

    @Override//认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        User user = null;
        // 1. 把AuthenticationToken转换为UsernamePasswordToken
        UsernamePasswordToken usertypeToken = (UsernamePasswordToken) token;
        // 2. 从UsernamePasswordToken中获取username
        String username = usertypeToken.getUsername();
        System.out.println("用户名"+username);
        // 3. 若用户不存在，抛出UnknownAccountException异常
        user = userService.login(username);
        if(user==null){
            throw new UnknownAccountException("用户不存在！！！");
        }
        // 4.
        // 根据用户的情况，来构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
        // 以下信息从数据库中获取
        // （1）principal：认证的实体信息，可以是username，也可以是数据表对应的用户的实体类对象
        Object principal = username;
        // （2）credentials：密码
        Object credentials = user.getPassword();
        System.out.println("密码"+credentials);
        // （3）realmName：当前realm对象的name，调用父类的getName()方法即可
        String realmName = this.getName();
        // （4）盐值：取用户信息中唯一的字段来生成盐值，避免由于两个用户原始密码相同，加密后的密码也相同
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        return new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
    }
}
