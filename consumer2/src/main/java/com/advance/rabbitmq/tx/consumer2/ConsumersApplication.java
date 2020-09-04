package com.advance.rabbitmq.tx.consumer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: rabbitmqtx
 * @description: 消费者启动类
 * @author: zhouh
 * @create: 2020-08-21 13:04
 **/
@SpringBootApplication
public class ConsumersApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumersApplication.class, args);
    }

}
