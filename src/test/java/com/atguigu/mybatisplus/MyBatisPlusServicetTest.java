package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.bean.User;
import com.atguigu.mybatisplus.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MyBatisPlusServicetTest {

    @Autowired
    private IUserService userService;

    @Test
    void testGetCount() {
        // 查询总记录数
        // SELECT COUNT( * ) FROM user
        long count = userService.count();
        System.out.println(count);
    }

    @Test
    void testInsertMore() {
        // SQL长度有限制，海量数据插入单条SQL无法实行，
        // 因此MP将批量插入放在了通用Service中实现，而不是通用Mapper
        // 批量添加
        // INSERT INTO user ( id, name, age ) VALUES ( ?, ?, ? )
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("ybc" + i);
            user.setAge(20 + i);
            list.add(user);
        }
        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }
}
