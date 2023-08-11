package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.pojo.User;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusPluginsTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage() {
        Page<User> page = new Page<>(1, 3);
        Page<User> userPage = userMapper.selectPage(page, null);
        System.out.println(userPage.getRecords()); //当前页的记录列表
        System.out.println(userPage.getPages()); //总页数
        System.out.println(userPage.getTotal()); //总记录数
        System.out.println(userPage.hasNext()); //是否有下一页
        System.out.println(userPage.hasPrevious()); //是否有上一页
    }

    @Test
    public void testPageVo() {
        Page<User> page = new Page<>(1, 3);
        Page<User> pageVo = userMapper.selectPageVo(page, 20);
        System.out.println(pageVo.getRecords());
        System.out.println(pageVo.getPages());
        System.out.println(pageVo.getTotal());
        System.out.println(pageVo.hasNext());
        System.out.println(pageVo.hasPrevious());
    }
}
