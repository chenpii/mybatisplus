package com.atguigu.mybatisplus.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @TableName("t_user")
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;
}
