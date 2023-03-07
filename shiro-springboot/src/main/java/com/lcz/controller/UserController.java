package com.lcz.controller;

import com.lcz.bean.User;
import com.lcz.service.UserServer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserServer userServer;

    @GetMapping("/GetUserName")
    @ResponseBody
    public String getUserName(){
        return "hello boy";
    }

    @GetMapping("/Add")
    public String add(){
        return "user/add";
    }


    @RequiresPermissions("user:new")
    @GetMapping("/Edit")
    public String edit(Model model){
        // 获取登录对象
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("username", user.getUsername());
        return "user/edit";
    }

    @GetMapping("/Login")
    public  String login(HttpSession session, String userName, String passWord, Model model){
        //获取当前用户
        System.out.println(userName);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,passWord);

        try {
            subject.login(token);
            session.setAttribute("username", userName);
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名错误");
            return  "login";
        }
        catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return  "login";
        }

    }



}
