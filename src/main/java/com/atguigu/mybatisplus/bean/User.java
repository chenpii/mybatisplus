package com.atguigu.mybatisplus.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @TableName("t_user")
public class User {

    // 将属性对应的字段指定为主键
    // @TablieId注解的value属性，用于指定主键的字段
    //      若实体类中主键对应的属性为id，而表中表示主键的字段为uid，此时若只在属性id上添加注解
    // @TableId注解的type属性，用于指定主键生成策略。
    //      IdType.AUTO     数据库的自增策略，需要确保数据库设置id自增
    //      默认为雪花算法生成
    // @TableId(value = "uid", type = IdType.AUTO)
    @TableId("uid")
    private Long id;

    // 指定属性对应的普通字段名
    @TableField("user_name")
    private String name;
    private Integer age;
    private String email;
}
