package com.advance.rabbitmq.tx.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: rabbitmqtx
 * @description: Producer启动类
 * @author: zhouh
 * @create: 2020-08-21 11:11
 **/
@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

}
