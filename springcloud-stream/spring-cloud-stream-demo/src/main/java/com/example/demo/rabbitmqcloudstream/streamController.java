package com.example.demo.rabbitmqcloudstream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RequestMapping("/rabbitmq")
@RestController
public class streamController {
    @Autowired
    private SinkReceiver sinkReceiver;

    @Autowired
    private MySinkReceiver mySinkReceiver;

    /**
     * 默认的消息通道
     *
     * @return
     */
    @RequestMapping("/send")
    public String send() {
        boolean send = sinkReceiver.send();
        return String.valueOf(send) + new Date();
    }

    /**
     * 自定义消息通道
     *
     * @return
     */
    @RequestMapping("/send2")
    public String send2() {
        boolean send = mySinkReceiver.send();
        return "自定义的通道消息发送：" + String.valueOf(send) + new Date();
    }

}
