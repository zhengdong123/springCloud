package com.springboot2.demo.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
//@ConfigurationProperties(prefix = "com")
public class FooProperties {
    private String foo;
    private String databasePlatform;
}
