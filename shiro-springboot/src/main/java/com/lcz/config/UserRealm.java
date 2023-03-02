package com.lcz.config;

import com.lcz.bean.User;
import com.lcz.service.UserServer;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserServer userServer;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进入授权");
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("进入认证");
        String username="root";
        String password="123456";
        User user = userServer.getById(1);
        System.out.println(user);
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        System.out.println(userToken.getUsername());
        if (!userToken.getUsername().equals("root")){
            return null;
        }
        return new SimpleAuthenticationInfo("",password,"");
    }
}
