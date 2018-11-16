package com.springboot2.demo;

import com.springboot2.demo.service.BlogProperties;
import com.springboot2.demo.service.FooProperties;
import com.springboot2.demo.service.PostInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BindPropertiesTests extends AbstractJUnit4SpringContextTests {


    @Autowired
    private BlogProperties blogProperties;


    /**
     * 测试获取配置数据
     */
    @Test
    public void testProperties() {
        Assert.assertEquals("zhangsan", blogProperties.getName());
        Assert.assertEquals("SpringBoot", blogProperties.getTitle());
        Assert.assertEquals("zhangsanxie<SpringBoot>", blogProperties.getDesc());

        logger.info("随机数测试输出：");
        logger.info("随机字符串 : " + blogProperties.getValue());
        logger.info("随机int : " + blogProperties.getNumber());
        logger.info("随机long : " + blogProperties.getBignumber());
        logger.info("随机10以下 : " + blogProperties.getTest1());
        logger.info("随机10-20 : " + blogProperties.getTest2());
    }

    /**
     * 测试绑定配置
     * 由于需要获取ApplicationContext , 在单元测试中只需要继承AbstractJUnit4SpringContextTests
     */
    @Test
    public void testBindProperties() {
        Binder binder = Binder.get(applicationContext.getEnvironment());

        // 绑定简单配置
        FooProperties foo = binder.bind("com", Bindable.of(FooProperties.class)).get();
        logger.info(foo.toString());

        // 绑定List配置
        List<String> post = binder.bind("com.post", Bindable.listOf(String.class)).get();
        logger.info(post);

        List<PostInfo> posts = binder.bind("com.posts", Bindable.listOf(PostInfo.class)).get();
        logger.info(posts);

        // 读取配置
        logger.info(applicationContext.getEnvironment().containsProperty("com.database-platform"));//true
        logger.info(applicationContext.getEnvironment().containsProperty("com.databasePlatform"));//false
    }

}
