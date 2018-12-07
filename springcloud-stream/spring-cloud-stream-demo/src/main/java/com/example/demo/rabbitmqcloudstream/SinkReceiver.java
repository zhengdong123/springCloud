package com.example.demo.rabbitmqcloudstream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 生产者
 */
@Component
@EnableBinding(Source.class)
public class SinkReceiver {
    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);
    @Autowired
    @Output(Source.OUTPUT)
    private MessageChannel channel;

    public boolean send() {
        boolean send = channel.send(MessageBuilder.withPayload("22222222222->" + UUID.randomUUID().toString()).build());
        return send ;
    }
}
