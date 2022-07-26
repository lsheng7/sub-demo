package com.example.subdemo.mail;

public interface SendMailService {

    /**
     * 简单文本邮件
     */
    void sendSimpleMail(MailRequest mailRequest);


    /**
     * Html格式邮件,可带附件
     */
    void sendHtmlMail(MailRequest mailRequest);
}
