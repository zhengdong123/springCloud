package com.springboot.hello.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * description:自定义配置属性
 * 方式一：在属性字段上使用@Value("${com.xxxx.name}")
 * 方式二：在类上使用@ConfigurationProperties(prefix = "com.person")
 *
 * @author z.d
 * @date 15:12 2018/11/15
 */

//@ConfigurationProperties(prefix = "com.person")
@Component
@Data
public class PersonProperties {

    @Value("${com.person.name}")
    private String name;

    @Value("${com.person.age}")
    private Integer age;

}
