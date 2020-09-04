package com.advance.rabbitmq.tx.producer.sender;

import com.advance.rabbitmq.tx.common.pojo.Message;
import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @program: rabbitmqtx
 * @description: rabbitmq消息发送工具类
 * @author: zhouh
 * @create: 2020-08-21 16:42
 **/
@Component
public class RabbitmqSender{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Message message, String exchange, String queue){
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        message.setDateTime(LocalDateTime.now());
        String data = JSONObject.toJSONString(message);
        rabbitTemplate.convertSendAndReceive(exchange, queue, data, correlationData);
    }

}
