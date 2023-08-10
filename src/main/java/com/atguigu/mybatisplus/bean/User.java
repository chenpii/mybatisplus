package com.atguigu.mybatisplus.bean;

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
    @TableId
    private Long uid;
    private String name;
    private Integer age;
    private String email;
}
