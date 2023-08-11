package com.atguigu.mybatisplus.mapper;

import com.atguigu.mybatisplus.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String, Object> selectMapById(Long id);

    void update();
}
