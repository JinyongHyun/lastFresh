package com.example.lastfresh.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;
/**
 * -----------------------------------------
 * @  : Email.java
 * @  : fancy
 * @  : fancydeepin@yeah.net
 * @  : 2012-6-12
 * @  :   Email
 * -----------------------------------------
 */

@Service
@RequiredArgsConstructor //final 붙은거 자동 오토와이어
@Slf4j
public class MailServiceImp implements MailService{
   /* private JavaMailSender javaMailSender;
    private SimpleMailMessage simpleMailMessage;

    *//**
     * @   : sendMail
     * @   ：@param subject
     * @   ：@param content
     * @   ：@param to            Email
     * @   :
     *//*

    public void sendUsernames(String email, List<String> usernames) {

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            *//**
             * new MimeMessageHelper(mimeMessage,true) true    ：
             *   true  ,          ：
             * use the true flag to indicate you need a multipart message
             *       ：  true,
             *      MimeMessageHelper API,       ：
             * supporting alternative texts, inline elements and attachments
             *     ,         (HTML)              true
             *      java.lang.IllegalStateException
             *//*
            *//**
             *              ,          ,    ,   API,     Set     ,
             *     HTML        ,     ,          ;
             *       ：  HTML          HTML   ,   ISO-8859-1,
             *  MimeMessageHelper        ：
             * MimeMessageHelper(MimeMessage mimeMessage, boolean multipart, String encoding)
             *     ,OK,          ,   ,
             *//*

            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
            messageHelper.setFrom(simpleMailMessage.getFrom());
            messageHelper.setSubject("아이디 찾기");
            messageHelper.setTo(email);
            messageHelper.setText(
                    "<html>" +
                            "<body>" +
                            "<BR>" +
                            "<div align='center'>" +
                            "<img src='cid:imageid'/>" +
                            "<BR>" +
                            "<h4>" +
                            "   fancydeepin  Blogjava：" +
                            "<a href='http://www.blogjava.net/fancydeepin/'>http://www.blogjava.net/fancydeepin/</a>" +
                            "</h4>" +
                            "</div>" +
                            "</body>" +
                            "</html>", true);

            ClassPathResource image = new ClassPathResource("images/body.png");
            messageHelper.addInline("imageid", image);
            javaMailSender.send(mimeMessage);    //  HTML

        } catch (Exception e) {System.out.println("    ：" + e);}
    }
    //Spring
    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessage = simpleMailMessage;
    }
    //Spring
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }*/
        @Autowired
        private JavaMailSender mailSender;



        @Override
        public void sendUsernames (String email, String usernames) throws MessagingException, IOException {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            final MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
            messageHelper.setTo(email);
            messageHelper.setSubject("아이디 찾기");
            messageHelper.setText(
                    "<html>" +
                            "<body>" +
                            "<BR>" +
                            "<div align='center' style = 'display: inline-table;'>" +
                            "<img src='cid:img' style='height: 94px;'/>" +
                            "<BR>" +
                            "<h1>" +
                            "안녕하세요. LastFresh입니다." +
                            "</h1>" +
                            "<h3>" +
                            "LastFresh 아이디찾기 아이디를 다음과 같이 알려드립니다." +
                            "</h3>" +
                            "<strong style ='font-size:12px;color:#333;line-height:18px;letter-spacing:-0.1px'>아이디 : "+usernames+"</strong>" +
                            "</div>" +
                            "</body>" +
                            "</html>", true);
            //Mail에 img 삽입
            ClassPathResource resource = new ClassPathResource("images/logo.png");
            messageHelper.addInline("img", resource);
            new Thread(new Runnable() {
                public void run() {
                    mailSender.send(mimeMessage);
                }
            }).start();
        }

}
