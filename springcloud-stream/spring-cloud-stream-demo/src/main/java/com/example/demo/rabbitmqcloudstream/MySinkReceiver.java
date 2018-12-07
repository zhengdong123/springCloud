package com.example.demo.rabbitmqcloudstream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
@EnableBinding(MySinkReceiver.MySource.class)
public class MySinkReceiver {
    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);
    @Autowired
    @Output(MySource.MY_OUTPUT)
    private MessageChannel channel;

    public boolean send() {
        boolean send = channel.send(MessageBuilder.withPayload("自定义的主题->" + UUID.randomUUID().toString()).build());
        return send ;
    }


    public interface MySource {
        String MY_OUTPUT = "myOutput";

        @Output(MySource.MY_OUTPUT)
        MessageChannel myOutput();
    }
}
