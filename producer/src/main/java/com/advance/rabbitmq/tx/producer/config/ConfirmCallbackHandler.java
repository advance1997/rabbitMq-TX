package com.advance.rabbitmq.tx.producer.config;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @Date 2020-08-24 09:44
 * @author 周舟
 */
public class ConfirmCallbackHandler implements RabbitTemplate.ConfirmCallback {

    /**
     * 1.如果消息没有到exchange,则confirm回调,ack=false
     * 2.如果消息到达exchange,则confirm回调,ack=true
     * @param correlationData 消息数据
     * @param ack 回复值
     * @param cause 出错时返回的错误原因
     */
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("消息唯一标识："+correlationData);
        if(ack){
            System.out.println("消息发送成功！");
        }else{
            System.out.println("失败原因："+cause);
        }
    }

}
