package com.advance.rabbitmq.tx.consumer2.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: rabbitmqtx
 * @description: rabbitMq配置类
 * @author: zhouh
 * @create: 2020-08-21 11:45
 **/
@Configuration
public class RabbitmqConfig {

    /**
     * 交换机名称
     */
    public static final String DEMO_TOPIC_EXCHANGE = "demo_topic_exchange";
    /**
     * 队列名称
     */
    public static final String DEMO_QUEUE = "demo_queue";

    /**
     * fanout交换机名称
     */
    public static final String DEMO_FANOUT_EXCHANGE = "demo_fanout_exchange";
    /**
     * fanout队列名称
     */
    public static final String DEMO_FANOUT_QUEUE = "demo_fanout_queue";
    /**
     * direct交换机名称
     */
    public static final String DEMO_DIRECT_EXCHANGE = "demo_direct_exchange";
    /**
     * direct队列名称
     */
    public static final String DEMO_DIRECT_QUEUE = "demo_direct_queue";

    /**
     * 声明Topic交换机Bean
     */
    @Bean("demoTopicExchange")
    public Exchange topicExchange(){
        return ExchangeBuilder.topicExchange(DEMO_TOPIC_EXCHANGE).durable(true).build();
    }

    /**
     * 声明Fanout交换机Bean
     */
    @Bean("demoFanoutExchange")
    public Exchange fanoutExchange(){
        return ExchangeBuilder.fanoutExchange(DEMO_FANOUT_EXCHANGE).durable(true).build();
    }
    /**
     * 声明direct交换机Bean
     */
    @Bean("demoDirectExchange")
    public Exchange directExchange(){
        return ExchangeBuilder.directExchange(DEMO_DIRECT_EXCHANGE).durable(true).build();
    }

    /**
     * 声明topic队列
     */
    @Bean("demoQueue")
    public Queue demoQueue(){
        return QueueBuilder.durable(DEMO_QUEUE).build();
    }

    /**
     * 声明fanout队列
     */
    @Bean("fanoutQueue")
    public Queue fanoutQueue(){
        return QueueBuilder.durable(DEMO_FANOUT_QUEUE).build();
    }

    /**
     * 声明direct队列
     */
    @Bean("directQueue")
    public Queue directQueue(){
        return QueueBuilder.durable(DEMO_DIRECT_QUEUE).build();
    }

    /**
     * 绑定topic队列和交换机
     */
    @Bean
    public Binding demoQueueExchange(@Qualifier("demoQueue") Queue queue,
                                     @Qualifier("demoTopicExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("demo.#").noargs();
    }

    /**
     * 绑定fanout队列和交换机
     */
    @Bean
    public Binding demoQueueFanoutExchange(@Qualifier("fanoutQueue") Queue queue,
                                           @Qualifier("demoFanoutExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("demo.fanout.#").noargs();
    }

    /**
     * 绑定direct队列和交换机
     */
    @Bean
    public Binding demoQueueDirectExchange(@Qualifier("directQueue") Queue queue,
                                           @Qualifier("demoDirectExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("demo.direct.#").noargs();
    }

}
