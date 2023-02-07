package com.teak.core.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Rabbit mq service.
 *
 * @author 柚mingle木
 * @version 1.0
 * @date 2023 /2/5
 */
@Service
public class RabbitMqServiceImpl {

    private static RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitMqServiceImpl(RabbitTemplate rabbitTemplate) {
        RabbitMqServiceImpl.rabbitTemplate = rabbitTemplate;
    }

    /**
     * 邮件发送<p>
     * Send message.
     *
     * @param exchange   交换机
     * @param routingKey 路由key
     * @param message    消息体
     */
    public void sendMessage(String exchange, String routingKey, Object message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}
