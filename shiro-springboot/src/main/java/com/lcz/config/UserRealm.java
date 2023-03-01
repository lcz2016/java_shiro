package com.lcz.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserRealm extends AuthorizingRealm {
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
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        System.out.println(userToken.getUsername());
        if (!userToken.getUsername().equals("root")){
            return null;
        }
        return new SimpleAuthenticationInfo("",password,"");
    }
}
