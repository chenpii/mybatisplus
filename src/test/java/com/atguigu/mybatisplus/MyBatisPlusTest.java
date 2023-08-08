package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.bean.User;
import com.atguigu.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelectList() {
        // 通过条件构造器查询一个list集合，若没有条件，则可以设置null为参数
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        // 实现新增用户信息
        // INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        User user = new User();
        user.setName("张三");
        user.setAge(34);
        user.setEmail("zhangsan@mail.com");
        int result = userMapper.insert(user);
        System.out.println("result:" + result);
        System.out.println("id:" + user.getId()); //在mybatisplus中，默认用的雪花算法生成的id
    }

    @Test
    public void testDeleteById() {
        // 通过id删除用户信息
        // DELETE FROM user WHERE id=?
        /* int result = userMapper.deleteById(1688736262360948738L);
        System.out.println("result:" + result); */

        // 根据map集合中所设置的条件删除用户信息
        // DELETE FROM user WHERE name = ? AND age = ?
        /*Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", "张三");
        hashMap.put("age", 34);
        int result = userMapper.deleteByMap(hashMap);
        System.out.println("result:" + result);*/

        // 通过多个id实现批量删除
        // DELETE FROM user WHERE id IN ( ? , ? , ? )
        List<Long> idList = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(idList);
        System.out.println("result:" + result);


    }
}
