package com.lcz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcz.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> ,BaseSqlMapper{
}
