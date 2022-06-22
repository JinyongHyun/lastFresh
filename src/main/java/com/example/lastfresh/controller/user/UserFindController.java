package com.example.lastfresh.controller.user;

import com.example.lastfresh.mapper.user.UserFindMapper;
import com.example.lastfresh.service.user.MailPwService;
import com.example.lastfresh.service.user.MailService;
import com.example.lastfresh.service.user.UserFindService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@RestController
@Controller
@Slf4j
@RequestMapping("/find/*")
public class UserFindController {

    @Autowired
    UserFindService userFindService;
    @Autowired
    UserFindMapper userFindMapper;
    @Autowired
    private MailService mailService;
    @Autowired
    private MailPwService mailPwService;


    @GetMapping("/check/sendSMS")
    public @ResponseBody
    String sendSMS(String phoneNumber) {

        Random rand  = new Random();
        String numStr = "";
        for(int i=0; i<4; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }

        System.out.println("수신자 번호 : " + phoneNumber);
        System.out.println("인증번호 : " + numStr);
        userFindService.certifiedPhoneNumber(phoneNumber,numStr);

        return numStr;
    }

    @GetMapping("/phoneNumber")
    public String phoneNumber(String userPhone, Model model){
        return userFindService.selectId(userPhone);
    }

    // 아이디 찾기 메일
    @PostMapping("/id/sendUsernames")
    public ResponseEntity<Object> sendEmail(String email, Model model) throws MessagingException, IOException {
        String usernames = userFindService.findId(email);
        /*model.addAttribute("proDetail", mailService.(email, usernames));*/
        if(usernames != null) {
            mailService.sendUsernames(email, usernames);
        }

        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    //비밀번호 찾기 메일
    @PostMapping("/pw/sendUsernames")
    public ResponseEntity<Object> sendEmailPw(String email, String id) throws MessagingException, IOException {
        /*String usernames = userFindService.findId(email);*/
        if(email != null) {
            mailPwService.sendUsernames(email, id);
        }

        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    //비밀번호 변경
    @PostMapping("/changePw")
    public String changePw(String pw, String id){
        log.info("---------------------------------");
        log.info(id);
        log.info(pw);
        log.info("---------------------------------");
        return userFindService.changePw(pw, id);}

}
