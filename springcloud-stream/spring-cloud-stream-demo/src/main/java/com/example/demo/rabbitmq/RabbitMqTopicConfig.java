package com.example.demo.rabbitmq;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqTopicConfig {
    //只接一个topic
    final static String message = "topic.message";
    //接收多个topic
    final static String messages = "topic.messages";

    @Bean
    public Queue queueMessage() {
        return new Queue(RabbitMqTopicConfig.message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(RabbitMqTopicConfig.messages);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    /**
     * 这里的Topic Exchange 转发消息主要是根据通配符，
     * 队列topic.message只能匹配topic.message的路由。
     * 而topic.messages匹配路由规则是topic.#，所以它可以匹配topic.开头的全部路由。
     * 而topic.#发送的消息也只能是topic.#的接受者才能接收。
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        //这里的#表示零个或多个词。
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
