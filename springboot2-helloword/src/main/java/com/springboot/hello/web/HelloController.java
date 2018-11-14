package com.springboot.hello.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 * 
 * @author z.d
 * 
 * @date 15:32 2018/11/15
 * 
 */
@RestController
public class HelloController {

    @RequestMapping("/index")
    public String index(){
        return "Hello World";
    }
}
