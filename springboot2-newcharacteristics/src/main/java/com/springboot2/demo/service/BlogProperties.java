package com.springboot2.demo.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * description:读取配置
 *
 * @author z.d
 * @date 14:21 2018/11/16
 */
@Component
@Data
public class BlogProperties {
    @Value("${com.blog.name}")
    private String name;
    @Value("${com.blog.title}")
    private String title;
    @Value("${com.blog.desc}")
    private String desc;

    @Value("${com.blog.value}")
    private String value;
    @Value("${com.blog.number}")
    private Integer number;
    @Value("${com.blog.bignumber}")
    private Long bignumber;
    @Value("${com.blog.test1}")
    private Integer test1;
    @Value("${com.blog.test2}")
    private Integer test2;
}
