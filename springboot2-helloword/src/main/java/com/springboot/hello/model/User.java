package com.springboot.hello.model;

import lombok.Data;

/**
 * description:User实体定义
 *
 * @author z.d
 * @date 16:30 2018/11/15
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
}
