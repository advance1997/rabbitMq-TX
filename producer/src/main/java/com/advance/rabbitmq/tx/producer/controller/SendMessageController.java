package com.advance.rabbitmq.tx.producer.controller;

import com.advance.rabbitmq.tx.common.pojo.Message;
import com.advance.rabbitmq.tx.producer.config.RabbitmqConfig;
import com.advance.rabbitmq.tx.producer.sender.RabbitmqSender;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: rabbitmqtx
 * @description: 消息发送controller
 * @author: zhouh
 * @create: 2020-08-21 12:59
 **/
@RestController
public class SendMessageController {

    /**
     * 注入RabbitMQ的模板
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitmqSender rabbitmqSender;

    @RequestMapping("/send/{msg}")
    public void sendMessage(@PathVariable("msg")String msg){
        rabbitTemplate.convertAndSend(RabbitmqConfig.DEMO_TOPIC_EXCHANGE ,"demo.hello" ,msg);
    }

    @RequestMapping("/send/message")
    public void sendMessageObj(@RequestBody Message message){
        rabbitmqSender.send(message, RabbitmqConfig.DEMO_TOPIC_EXCHANGE,"demo.hello" );
    }

    @RequestMapping("/fanout/send/message")
    public void sendFanoutMessageObj(@RequestBody Message message){
        rabbitmqSender.send(message, RabbitmqConfig.DEMO_FANOUT_EXCHANGE,"demo.fanout.hello" );
    }


    @RequestMapping("/direct/send/message")
    public void sendDirectMessageObj(@RequestBody Message message){
        rabbitmqSender.send(message, RabbitmqConfig.DEMO_DIRECT_EXCHANGE, "" );
    }

}
