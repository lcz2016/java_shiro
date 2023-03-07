package com.lcz.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lcz.bean.User;
import com.lcz.service.UserServer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserServer userServer;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进入授权");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        System.out.println(user);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("user:edit");
        info.addRole("admin");
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("进入认证");
        String password="123456";
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("LoginName", userToken.getUsername());
        List<User> userList = userServer.list(userQueryWrapper);

        if (userList.size()<=0){
            throw new UnknownAccountException("账号不存在！");
        }
        return new SimpleAuthenticationInfo(userList.get(0), userToken.getCredentials(), "userRealm");
    }
}
