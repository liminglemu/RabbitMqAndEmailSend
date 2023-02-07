package com.teak.core.service.serviceImpl;

import com.teak.core.email.SenderEntity;
import com.teak.core.result.EmailResult;
import com.teak.core.result.EmailResultEnum;
import com.teak.core.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * The type Email service.
 *
 * @author 柚mingle木
 * @version 1.0
 * @date 2023 /2/5
 */
@Service
public class EmailServiceImpl implements EmailService {

    private static JavaMailSender javaMailSender;
    private static SenderEntity senderEntity;
    private static String name;
    private List<String> fileNameList;

    @Autowired
    private EmailServiceImpl(JavaMailSender javaMailSender, SenderEntity senderEntity) {
        System.err.println(" 构造器启动 ");
        EmailServiceImpl.javaMailSender = javaMailSender;
        EmailServiceImpl.senderEntity = senderEntity;
    }

    public EmailResult<String> sendMessage(String receiver, String messageSubject, String messageContent) {

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(senderEntity.getUsername()); //设置发送方
            simpleMailMessage.setTo(receiver); //接收方
            simpleMailMessage.setSubject(messageSubject); //发送主题
            simpleMailMessage.setText(messageContent);  //发送内容
            simpleMailMessage.setSentDate(new Date()); //设置发送时间
            javaMailSender.send(simpleMailMessage);
            return new EmailResult<>(EmailResultEnum.SUCCESS, null);
        } catch (MailException e) {
            return new EmailResult<>(EmailResultEnum.FAIL, e.getMessage());
        }
    }

    public EmailResult<List<String>> sendFilesAndMessage(String receiver, String messageSubject, String messageContent, File[] files) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            mimeMessageHelper.setFrom(senderEntity.getUsername());
            mimeMessageHelper.setTo(receiver);
            mimeMessageHelper.setSubject(messageSubject);
            mimeMessageHelper.setText(messageContent);
            mimeMessageHelper.setSentDate(new Date());
            if (files != null && files.length > 0) {
                fileNameList = new ArrayList<>();
                Arrays.stream(files).forEach(file -> {
                    try {
                        name = file.getName();
                        fileNameList.add(name);
                        System.err.println("file.getName() = " + name);
                        mimeMessageHelper.addAttachment(file.getName(), file);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (MessagingException e) {
            e.printStackTrace();
            return new EmailResult<>(EmailResultEnum.FAIL, List.of(e.getMessage()));
        }
        javaMailSender.send(mimeMessage);
        return new EmailResult<>(EmailResultEnum.SUCCESS, fileNameList);
    }

}
