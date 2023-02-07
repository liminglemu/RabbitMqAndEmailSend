package com.teak.core.service;

import com.teak.core.result.EmailResult;

import java.io.File;
import java.util.List;

/**
 * The interface Email service.
 *
 * @author 柚mingle木
 * @version 1.0
 * @date 2023 /2/5
 */
public interface EmailService {

    /**
     * Send message email result.
     *
     * @param receiver       接收方邮件地址
     * @param messageSubject 主题
     * @param messageContent 邮件内容
     * @return 返回结果成功或失败信息
     */
    EmailResult<String> sendMessage(String receiver, String messageSubject, String messageContent);

    /**
     * Send files and message.
     *
     * @param receiver       the receiver
     * @param messageSubject the message subject
     * @param messageContent the message content
     * @param files          文件，可以发送多个文件
     * @return 返回结果成功或失败信息
     */
    EmailResult<List<String>> sendFilesAndMessage(String receiver, String messageSubject, String messageContent, File[] files);

}
