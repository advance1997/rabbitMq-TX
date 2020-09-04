package com.advance.rabbitmq.tx.consumer2.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

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
