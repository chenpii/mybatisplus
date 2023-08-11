package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.pojo.User;
import com.atguigu.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testUpdate() {
        // 修改用户信息
        // UPDATE user SET name=?, email=? WHERE id=?
        User user = new User();
        user.setId(4L);
        user.setName("李四");
        user.setEmail("lisi@atguigu.com");
        int result = userMapper.updateById(user);
        System.out.println("result:" + result);
    }

    @Test
    public void testSelect() {

        // 通过id查询用户信息
        // SELECT id,name,age,email FROM user WHERE id=?
        /* User user = userMapper.selectById(1L);
        System.out.println(user); */

        // 根据多个id查询多个用户信息
        // SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
        /*List<Long> idLists = Arrays.asList(1L, 2L, 3L);
        List<User> users = userMapper.selectBatchIds(idLists);
        users.forEach(System.out::println); */

        // 根据map集合中的条件查询用户信息
        // SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        /* HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Jack");
        map.put("age", 20);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);*/

        // 查询所有用户信息
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

        // 根据id查询用户信息map集合-自定义
        /*Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);*/
    }
}
