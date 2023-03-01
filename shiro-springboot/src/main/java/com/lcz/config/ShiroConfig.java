package com.lcz.config;

import com.fasterxml.jackson.core.sym.Name;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean:3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        System.out.println("1");
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(securityManager);
        //添加shiro的内置过滤器
        /*
           anon :无需认证就可以访问
           authc :必须认证才能访问
           user :必须拥有记住我 功能才能访问 ,一般不用
           perms :拥有某些资源权限才可以访问
           role : 用户某个角色权限才可以访问
         * */
        Map<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
        filterChainDefinitionMap.put("/Index","anon");
        filterChainDefinitionMap.put("/ToLogin","anon");
        filterChainDefinitionMap.put("/User/Login","anon");
        filterChainDefinitionMap.put("/User/*","authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        bean.setLoginUrl("/ToLogin");
        bean.setUnauthorizedUrl("/ToLogin");
        return bean;
    }
    //DefaultWebSecurityManager:2
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm);
        System.out.println("2");
        return manager;
    }
    //创建realm 对象,用户认证，需自定义类：1
    @Bean
    public UserRealm userRealm(){
        System.out.println("3");
        return new UserRealm();
    }
}
