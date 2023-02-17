package com.lcz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping({"/","/Index"})
    public  String index(Model model){
        model.addAttribute("title","首页-欢迎您2112！!！");
        return "index";
    }
    @GetMapping("/ToLogin")
    public String tologin(){
        return "/login";
    }
}
