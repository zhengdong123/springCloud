package com.example.demo.rabbitmqcloudstream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.SubscribableChannel;

@EnableBinding(MyConsumer.MySink.class)
public class MyConsumer {

    @StreamListener(MySink.INPUT)
    public void receive(Message<String> message) {
        System.out.println("自定义  -> 接收到MQ消息:" + message.toString());

    }

    public interface MySink {

        String INPUT = "myInput";

        @Input(MySink.INPUT)
        SubscribableChannel input();

    }
}
