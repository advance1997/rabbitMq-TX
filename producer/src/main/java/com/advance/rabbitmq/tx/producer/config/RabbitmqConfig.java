package com.advance.rabbitmq.tx.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @program: rabbitmqtx
 * @description: rabbitMq配置类
 * @author: zhouh
 * @create: 2020-08-21 11:45
 **/
@Configuration
public class RabbitmqConfig {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 交换机名称
     */
    public static final String DEMO_TOPIC_EXCHANGE = "demo_topic_exchange";
    /**
     * 队列名称
     */
    public static final String DEMO_QUEUE = "demo_queue";

    /**
     * 声明交换机Bean
     */
    @Bean("demoTopicExchange")
    public Exchange topicExchange(){
        return ExchangeBuilder.topicExchange(DEMO_TOPIC_EXCHANGE).durable(true).build();
    }

    /**
     * 声明队列
     */
    @Bean("demoQueue")
    public Queue demoQueue(){
        return QueueBuilder.durable(DEMO_QUEUE).build();
    }

    /**
     * 绑定队列和交换机
     */
    @Bean
    public Binding demoQueueExchange(@Qualifier("demoQueue") Queue queue,
                                     @Qualifier("demoTopicExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("demo.#").noargs();
    }

    @PostConstruct
    public void rabbitTemplate(){
        rabbitTemplate.setConfirmCallback(new ConfirmCallbackHandler());
    }

}
