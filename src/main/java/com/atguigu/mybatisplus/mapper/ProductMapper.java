package com.atguigu.mybatisplus.mapper;

import com.atguigu.mybatisplus.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository // 持久化注册到IOC容器中，避免Mapper@autowired标红，但运行正常不报错
public interface ProductMapper extends BaseMapper<Product> {
}
