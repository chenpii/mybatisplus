package com.atguigu.mybatisplus.mapper;

import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户id查询用户信息为map集合
     *
     * @param id
     * @return
     */
    Map<String, Object> selectMapById(Long id);

    // void update();

    /**
     * 根据年龄查询分页信息
     *
     * @param page MyBatis-Plus提供的分页对象，必须位于第一个参数的位置
     * @param age
     * @return
     */
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);
}
