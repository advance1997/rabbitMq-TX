package com.advance.rabbitmq.tx.producer.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @program: rabbitmqtx
 * @description: 消息回复处理器
 * @author: zhouh
 * @create: 2020-08-24 09:53
 **/
public class ReturnCallbackHandler implements RabbitTemplate.ReturnCallback {

    /**
     * exchange到queue成功,则不回调return
     * exchange到queue失败,则回调return(需设置mandatory=true,否则不回调,消息就丢了)
     * 当消息从交换机到队列失败时，该方法被调用。（若成功，则不调用）
     *       需要注意的是：该方法调用后，MsgSendConfirmCallBack中的confirm方法也会被调用，且ack = true
     * @param message
     * @param replyCode
     * @param replyText
     * @param exchange
     * @param routingKey
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("return exchange: " + exchange + ", routingKey: "
                + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText);
    }

}
