package com.example.subdemo.mail;

import io.swagger.annotations.Api;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send-mail")
@Api(value = "发送邮件接口", tags = {"发送邮件接口"})
public class SendMailController {

    @Resource
    private SendMailService sendMailService;

    @PostMapping("/simple")
    public void SendSimpleMessage(@RequestBody MailRequest mailRequest) {
        sendMailService.sendSimpleMail(mailRequest);
    }

    @PostMapping("/html")
    public void SendHtmlMessage(@RequestBody MailRequest mailRequest) {
        sendMailService.sendHtmlMail(mailRequest);
    }
}
