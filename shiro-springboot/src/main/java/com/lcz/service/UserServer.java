package com.lcz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lcz.bean.User;
import com.lcz.mapper.UserMapper;
import org.springframework.stereotype.Service;

public interface UserServer  extends IService<User> {
    void getCount();

}
