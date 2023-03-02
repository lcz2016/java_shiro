package com.lcz.controller;

import com.lcz.service.UserServer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "User/Add";
    }
    @GetMapping("/Edit")
    public String edit(){
        return "User/Edit";
    }

    @GetMapping("/Login")
    public  String login(String userName,String passWord,Model model){
        //获取当前用户
        System.out.println(userName);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,passWord);

        try {
            subject.login(token);
            model.addAttribute("msg",userName);
            return "/index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名错误");
            return  "/login";
        }
        catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return  "/login";
        }

    }

}
