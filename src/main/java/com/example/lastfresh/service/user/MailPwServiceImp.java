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

@Service
@RequiredArgsConstructor //final 붙은거 자동 오토와이어
@Slf4j
public class MailPwServiceImp implements MailPwService{
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendUsernames (String email, String id) throws MessagingException, IOException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        final MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
        messageHelper.setTo(email);
        messageHelper.setSubject("비밀번호 찾기");
        messageHelper.setText(
                "<html>" +
                        "<body>" +
                        "<BR>" +
                        "<div align='center' style = 'display: inline-table;'>" +
                        "<input type='hidden' class='id' value="+id+">" +
                        "<img src='cid:img' style='height: 94px;'/>" +
                        "<BR>" +
                        "<h1>" +
                        "안녕하세요. LastFresh입니다." +
                        "</h1>" +
                        "<p>" +
                        "아래 버튼을 눌러" +
                        "<strong style ='font-size:12px;color:#333;line-height:18px;letter-spacing:-0.1px'>" +
                        " 비밀번호" +
                        "</strong>" +
                        "를 재설정 해주세요." +
                        "</p>" +
                        "<div style ='margin-top: 30px;'>" +
                        "<button type='button'  style='width: 150px; color: #f8f8f8;" +
                        "    height: 50px;" +
                        "    font-size: 12px;" +
                        "    font-weight: 900;" +
                        "    background-color: #DA291C;'><a href='user/manage/userNewPw?id ="+id+"'>비밀번호 재설정</a></button>" +
                        "</div>" +
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
