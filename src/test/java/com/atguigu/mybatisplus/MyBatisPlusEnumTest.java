package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.enums.SexEnum;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusEnumTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {

        User user = new User();
        user.setName("admin2");
        user.setAge(34);
        user.setSex(SexEnum.MALE);
        int result = userMapper.insert(user);
        System.out.println("result:" + result);

    }
}
