package com.springboot.hello.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserRestControllerTest {
    private MockMvc mvc;


    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new UserRestController()).build();
    }

    @Test
    public void testUserController() throws Exception {
        RequestBuilder requestBuilder = null;

        // 1、get查一下user列表，应该为空
        requestBuilder = get("/users/");
        mvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        // 2、post提交一个user
        requestBuilder = post("/users/")
                .param("id", "1")
                .param("name", "zhangsan")
                .param("age", "20");
        mvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));

        // 3、get获取user列表，应该有刚才插入的数据
        requestBuilder = get("/users/");
        mvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().string((equalTo("[{\"id\":1,\"name\":\"zhangsan\",\"age\":20}]"))));

        // 4、put修改id为1的user
        requestBuilder = put("/users/1").param("name", "王五")
                .param("age", "25");
        mvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));

        // 5、get一个id为1的user
        requestBuilder = get("/users/1");
        mvc.perform(requestBuilder)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"王五\",\"age\":25}")));

        // 6、del删除id为1的user
        requestBuilder = delete("/users/1");
        mvc.perform(requestBuilder)
                .andExpect(content().string(equalTo("success")));

        // 7、get查一下user列表，应该为空
        requestBuilder = get("/users/");
        mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }
}
