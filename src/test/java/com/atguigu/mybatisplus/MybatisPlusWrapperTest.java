package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.bean.User;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusWrapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test01() {
        // 查询用户名包含a，年龄在20到30之间，并且邮箱不为Null的用户信息
        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (user_name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("user_name", "a") //数据库中的字段名
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test02() {
        // 查询用户信息，按照年龄的降序排序，若年龄相同，则按照id升序排序
        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 ORDER BY age DESC,uid ASC
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.orderByDesc("age")
                .orderByAsc("uid");
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test03() {
        // 删除邮箱地址为NULL的用户信息
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.isNull("email");
        int result = userMapper.delete(userQueryWrapper); //逻辑删除
        System.out.println("result:" + result);
    }

    @Test
    public void test04() {
        // 组装修改条件  将(年龄大于20并且用户名中包含有a)或邮箱为null的用户信息修改
        // UPDATE t_user SET user_name=?, email=? WHERE is_deleted=0 AND (age > ? AND user_name LIKE ? OR email IS NULL)
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.gt("age", 20)
                .like("user_name", "a")
                .or()
                .isNull("email");
        User user = new User();
        user.setName("小明");
        user.setEmail("test@atguigu.com");
        int result = userMapper.update(user, userQueryWrapper);//第一个实体类参数：用于填充修改的内容；第二个条件构造器参数：用于设置修改的条件
        System.out.println("result:" + result);

    }

    /**
     * 条件优先级  将用户名中包含a并且(年龄大于20或邮箱为null)的用户信息修改
     **/
    @Test
    public void test05() {
        // lambda中条件优先执行
        /*
            UPDATE t_user SET user_name=?, email=?
            WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR email IS NULL))
         */
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("user_name", "a")
                .and(i -> i.gt("age", 20)
                        .or()
                        .isNull("email"));
        User user = new User();
        user.setName("小红");
        user.setEmail("test2@atguigu.com");
        int result = userMapper.update(user, userQueryWrapper);
        System.out.println("result:" + result);
    }

    @Test
    public void test06() {
        // 查询用户的姓名、年龄、邮箱信息
        // SELECT user_name,age,email FROM t_user WHERE is_deleted=0
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("user_name", "age", "email");
        List<Map<String, Object>> mapList = userMapper.selectMaps(userQueryWrapper);
        mapList.forEach(System.out::println);
    }

    /**
     * 组装子查询 查询id小于100的用户信息
     **/
    @Test
    public void test07() {
        // 查询id小于100的用户信息
        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user
        // WHERE is_deleted=0 AND (uid IN (select uid from t_user where uid < 100))
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.inSql("uid", "select uid from t_user where uid < 100");
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);
    }
}
