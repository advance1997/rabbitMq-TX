package com.advance.rabbitmq.tx.producer.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: rabbitmqtx
 * @description: rabbitmq消息发送工具类
 * @author: zhouh
 * @create: 2020-08-21 16:42
 **/
@Component
public class RabbitmqSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void send(){

    }

}
