package com.lcz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lcz.bean.User;
import com.lcz.mapper.UserMapper;
import com.lcz.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServerImpl extends ServiceImpl<UserMapper, User> implements UserServer {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void getCount() {
        List<HashMap> hashMaps = userMapper.selectData("select *from ba_users");
        System.out.println(hashMaps);
    }
}
