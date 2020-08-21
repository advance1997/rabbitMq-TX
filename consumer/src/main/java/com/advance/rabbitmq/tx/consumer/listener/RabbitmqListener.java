package com.advance.rabbitmq.tx.consumer.listener;

import com.advance.rabbitmq.tx.consumer.config.RabbitmqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: rabbitmqtx
 * @description: 消息监听者
 * @author: zhouh
 * @create: 2020-08-21 13:09
 **/
@Component
@Slf4j
public class RabbitmqListener {

    @RabbitListener(queues = RabbitmqConfig.DEMO_QUEUE)
    public void receive(String message) {
        log.info("消费者收到消息：{}", message);
    }

}
