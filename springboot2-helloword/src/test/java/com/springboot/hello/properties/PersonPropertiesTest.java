package com.springboot.hello.properties;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class PersonPropertiesTest {

    @Autowired
    private PersonProperties personProperties;

    @Test
    public void propertiesTest() {
        Assert.assertEquals(personProperties.getName(), "zhengdong");
        Assert.assertTrue(personProperties.getAge() == 18);
    }
}
