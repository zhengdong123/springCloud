package com.example.demo.rabbitmq;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * description:队列配置，队列的名称，发送者和接受者的名称必须一致，否则接收不到消息
 *
 * @author z.d
 *
 * @date 10:00 2018/11/27
 *
 */
@Configuration
public class RabbitMqConfig {
    @Bean
    public Queue Queue1() {
        return new Queue("testQueue1");
    }
    @Bean
    public Queue Queue2() {
        return new Queue("testQueue2");
    }


}
