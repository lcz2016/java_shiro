package com.lcz.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping({"/","/Index"})
    public  String index(Model model){
        model.addAttribute("title","首页-欢迎您211！!！");
        return "index";
    }
    @GetMapping("/ToLogin")
    public String tologin(Model model){
        model.addAttribute("msg","");
        return "login";
    }
    @GetMapping("/ToLoginOut")
    public String tologinout(Model model){
        SecurityUtils.getSubject().logout();
        return "index";
    }

    @GetMapping("/NoPerms")
    public String noperms(Model model){
        model.addAttribute("msg","");
        return "noperms";
    }
}
