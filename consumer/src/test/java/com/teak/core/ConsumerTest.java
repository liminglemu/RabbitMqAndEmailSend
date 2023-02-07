package com.teak.core;

import com.teak.core.email.ReceiverEntity;
import com.teak.core.email.SenderEntity;
import com.teak.core.mq.EmailAndRabbitMq;
import com.teak.core.result.EmailResult;
import com.teak.core.service.EmailService;
import com.teak.core.service.RabbitMqServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.List;

/**
 * The type Consumer test.
 *
 * @author 柚mingle木
 * @version 1.0
 * @date 2023 /2/5
 */
@SpringBootTest
public class ConsumerTest {

    private static EmailService emailService;

    private static SenderEntity senderEntity;

    private static RabbitMqServiceImpl rabbitMqServiceImpl;

    /**
     * Instantiates a new Consumer test.
     *
     * @param emailService        the email service
     * @param senderEntity        the sender entity
     * @param rabbitMqServiceImpl the rabbit mq service
     */
    @Autowired
    public ConsumerTest(EmailService emailService, SenderEntity senderEntity, RabbitMqServiceImpl rabbitMqServiceImpl) {
        ConsumerTest.emailService = emailService;
        ConsumerTest.senderEntity = senderEntity;
        ConsumerTest.rabbitMqServiceImpl = rabbitMqServiceImpl;
    }

    /**
     * Test 1.
     */
    @Test
    public void test1() {
//        emailService.sendMessage("themadmancsgo@gmail.com", "这是最终的测试了", "用来测试邮件发送");
        File file = new File("E:\\Music\\Night Drive - Wilee.mp3");
        ReceiverEntity receiver = new ReceiverEntity("themadmancsgo@gmail.com", "这是最终的测试了",
                "加油????", new File[]{file});
        EmailResult<List<String>> listEmailResult = emailService.sendFilesAndMessage(receiver.getReceiver(), receiver.getMessageSubject(), receiver.getMessageContent(), receiver.getFiles());
        System.out.println("listEmailResult = " + listEmailResult);
    }

    /**
     * Test 2.
     */
    @Test
    public void test2() {
        String username = senderEntity.getUsername();
        System.out.println("username = " + username);
    }

    /**
     * Test 3.
     */
    @Test
    public void test3() {
        File file = new File("E:\\Music\\Night Drive - Wilee.mp3");
        ReceiverEntity receiver = new ReceiverEntity("themadmancsgo@gmail.com", "这是最终的测试了",
                "发送歌曲", new File[]{file});
        rabbitMqServiceImpl.sendMessage(EmailAndRabbitMq.EXCHANGE_EMAIL, EmailAndRabbitMq.ROUTING_KEY_EMAIL, receiver);
    }


}