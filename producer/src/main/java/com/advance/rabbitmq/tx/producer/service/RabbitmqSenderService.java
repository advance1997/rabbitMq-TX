package com.advance.rabbitmq.tx.producer.service;

import java.util.Map;

/**
 * @ClassName RabbitmqSenderService
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/8/21 16:39
 * @Version V1.0
 **/
public interface RabbitmqSenderService {

    void sender(Object message, Map<String, Object> properties);

}
