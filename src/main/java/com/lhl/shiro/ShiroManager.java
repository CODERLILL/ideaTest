package com.lhl.shiro;

import com.lhl.bean.User;
import com.lhl.service.UserService;
import com.lhl.service.impl.UserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

//自定义Realm类
//暂停使用
public class ShiroManager extends AuthorizingRealm {

    @Resource
    private UserServiceImpl UserService;

    @Override//为当前登录成功的用户授予权限和角色，已经登录成功了。
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(UserService.getRoles(username));
        authorizationInfo.setStringPermissions(UserService.getPermissions(username));

        return authorizationInfo;

    }

    @Override//验证当前登录的用户，获取认证信息。
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String)token.getPrincipal();//获取用户名
        System.out.println("realm"+userName);
        User user = UserService.login(userName);
        if (user!=null){
            AuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),"myRealm");
            return info;
        }else {
            return null;
        }

    }

}
