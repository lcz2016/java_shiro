package com.lcz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/User")
public class UserController {
    @GetMapping("/GetUserName")
    @ResponseBody
    public String getUserName(){
        return "hello boy";
    }

    @GetMapping("/Add")
    public String add(){
        return "user/add";
    }
    @GetMapping("/Edit")
    public String edit(){
        return "user/edit";
    }

}
