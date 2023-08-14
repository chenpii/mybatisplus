package com.atguigu.mybatisplus.service.impl;

import com.atguigu.mybatisplus.pojo.User;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.service.IUserService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@DS("master") //指定操作的数据源
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
