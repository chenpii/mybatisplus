package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.ProductMapper;
import com.atguigu.mybatisplus.pojo.Product;
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

    @Autowired
    private ProductMapper productMapper;

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

    /**
     * 模拟冲突
     */
    @Test
    public void testProduct01() {
        // 1.小李查询商品价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李查询的价格：" + productLi.getPrice());
        // 2.小王查询商品价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小王查询的价格：" + productWang.getPrice());
        // 3.小李将商品价格+50
        productLi.setPrice(productLi.getPrice() + 50);
        productMapper.updateById(productLi);
        // 4.小王将商品价格-30
        productWang.setPrice(productWang.getPrice() - 30);
        productMapper.updateById(productWang);
        // 5.老板查询商品价格
        Product productLB = productMapper.selectById(1);
        System.out.println("老板查询的价格：" + productLB.getPrice());
    }
}
