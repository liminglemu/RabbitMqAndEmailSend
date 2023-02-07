package com.teak.core.listener;

import com.alibaba.fastjson2.JSONObject;
import com.teak.core.email.ReceiverEntity;
import com.teak.core.mq.EmailAndRabbitMq;
import com.teak.core.result.EmailResult;
import com.teak.core.service.EmailService;
import org.jetbrains.annotations.NotNull;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * The type Rabbit mq consumer.
 *
 * @author 柚mingle木
 * @version 1.0
 * @date 2023 /2/5
 */
@Component
public class RabbitMqConsumer {

    private static EmailService emailService;

    @Autowired
    private RabbitMqConsumer(EmailService emailService) {
        RabbitMqConsumer.emailService = emailService;
    }

    /**
     * 监听器也是消费者，监听rabbitMq中消息，进行处理分发<p>
     * Rabbit mq listener.
     *
     * @param message the message
     */
    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = EmailAndRabbitMq.QUEUE_EMAIL)
            , exchange = @Exchange(name = EmailAndRabbitMq.EXCHANGE_EMAIL), key = EmailAndRabbitMq.ROUTING_KEY_EMAIL))
    public void rabbitMqListener(@NotNull Message message) {
        ReceiverEntity receiverEntity = JSONObject.parseObject(new String(message.getBody(), StandardCharsets.UTF_8), ReceiverEntity.class);
        if (receiverEntity.getFiles() != null) {
            EmailResult<List<String>> listEmailResult = emailService.sendFilesAndMessage(receiverEntity.getReceiver(), receiverEntity.getMessageSubject(), receiverEntity.getMessageSubject(), receiverEntity.getFiles());
            System.err.println("listEmailResult = " + listEmailResult);
        } else {
            EmailResult<String> stringEmailResult = emailService.sendMessage(receiverEntity.getReceiver(), receiverEntity.getMessageSubject(), receiverEntity.getMessageContent());
            System.err.println("stringEmailResult = " + stringEmailResult);
        }
    }
}
