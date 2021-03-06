package com.advance.rabbitmq.tx.consumer.listener;

import com.advance.rabbitmq.tx.consumer.config.RabbitmqConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @program: rabbitmqtx
 * @description: 消息监听者
 * @author: zhouh
 * @create: 2020-08-21 13:09
 **/
//@Component
@Slf4j
//@RabbitListener(queues = RabbitmqConfig.DEMO_QUEUE)
public class RabbitmqListener {

//    @RabbitHandler
    public void receive(@Payload String body, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Message message, Channel channel) {
        log.info("消费者收到消息：{}", body);
        log.info("Message:"+message);
        try {
            channel.basicAck(deliveryTag, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
