package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.service.IProductService;
import com.atguigu.mybatisplus.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

@SpringBootTest
public class MybatisPlusDatasourceApplicationTests {

    @Autowired
    IUserService userService;

    @Autowired
    IProductService productService;

    @Test
    public void test() {
        System.out.println(userService.getById(1L));
        System.out.println(productService.getById(1L));

    }
}
