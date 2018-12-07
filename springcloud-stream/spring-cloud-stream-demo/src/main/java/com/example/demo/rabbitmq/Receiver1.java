package com.example.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * description:需要在rabbitmq中先创建队列 testQueue1
 *
 * @author z.d
 * @date 10:15 2018/11/27
 */
@Component
@RabbitListener(queues = "testQueue1")
public class Receiver1 {
    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("接收者testQueue1--> receiver:" + msg);
    }

}
