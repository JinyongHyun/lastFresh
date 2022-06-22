package com.example.lastfresh.controller.user;


import com.example.lastfresh.domain.repository.UserRepository;
import com.example.lastfresh.domain.vo.UserVO;
import com.example.lastfresh.service.user.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

/*유저 아이디찾기, 비밀번호찾기, 비밀번호 재설정, 회원가입, 로그인*/

@Controller
@Slf4j
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserManaingController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    //회원가입
    @PostMapping("/manage/userJoin")
    public String Join(UserVO userVO) {
        userService.join(userVO);
        return "user/manage/userLogin";
    }
    //카카오로그인 js
    @GetMapping("/manage/kakao")
    public String kakao(String userKakao, Model model){
            model.addAttribute("userKakao",userKakao);
        return "user/manage/userJoin";
    }

    //로그아웃
    @GetMapping("/manage/logout")
    public String logout(HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        session.invalidate(); //세션 삭제
        return "user/manage/userLogin";
    }


    //로그인
    @PostMapping("/manage/userLogin")
    public String login(@RequestParam String userId, String userPw, HttpServletRequest request, Model model, RedirectAttributes rttr) throws Exception {
        log.info("Post 로그인 실행");

        UserVO userVO = userService.decryption(userId, userPw);
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
//    log.info("로그인 실행");
//    log.info("userVO"+userVO.toString());

        if (userVO == null) {//로그인실패
            rttr.addFlashAttribute("msg", "로그인실패");
            return "redirect:userLogin";
        }else {
            session.setAttribute("userNumber", userVO.getUserNum());
            session.setAttribute("userId", userVO.getUserId());
            session.setAttribute("userStatus", userVO.getUserStatus());
            return "redirect:/main/moveMain";
        }
    }


    //카카오 + 회원유형
    @GetMapping("/manage/userSelect")
    public String userSelectwithKakao(String userKakao, Model model, HttpServletRequest request){
        log.info("userSelect 실행");
        log.info(("userKakao" + userKakao));

        UserVO byUserKakao = userRepository.findByUserKakao(userKakao);

//        log.info(("userKakao" + byUserKakao));
//        log.info(("userKakao객체" + byUserKakao.toString()));
        HttpSession session = request.getSession();


        log.info("userNull 실행1");
        if(byUserKakao != null){
            log.info("userNotNull 실행");
            session.setAttribute("userNumber", byUserKakao.getUserNum());
            session.setAttribute("userVO", byUserKakao);

            session.setAttribute("userId", byUserKakao.getUserId());
            session.setAttribute("userStatus", byUserKakao.getUserStatus());
//            mav.setView(new RedirectView("/main/main"));
            return "redirect:/main/moveMain";
        }

        log.info("userNull 실행2");

        model.addAttribute("userKakao",userKakao);
        log.info("userKakao" + userKakao);
        return "user/manage/userSelect";
    }

    //회원유형
    @PostMapping("/manage/userSelect")
    public String userSelect(String userKakao, String selector, Model model) {
        log.info("회원유형");
        log.info(userKakao);
        model.addAttribute("userKakao",userKakao);
        String userStatus = this.getUserStatus(selector);
        model.addAttribute("userStatus", userStatus);
        return "user/manage/userJoin";
    }

    private String getUserStatus(String selector) {
        if ("일반회원".equals(selector)) {
            return "1";
        }

        if ("판매자".equals(selector)) {
            return "2";
        }

        if ("라이더".equals(selector)) {
            return "3";
        }

        return "1";

    }

    //휴대폰인증
    @GetMapping("/manage/phoneCheck")
    public @ResponseBody
    String sendSMS(String userPhone) {

        Random rand = new Random();
        String numStr = "";
        for (int i = 0; i < 4; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr += ran;
        }
        System.out.println("수신자 번호 : " + userPhone);
        System.out.println("인증번호 : " + numStr);
        userService.certifiedPhoneNumber(userPhone, numStr);
        return numStr;
    }


    //아이디 중복검사
    @GetMapping("/manage/IDCheck/{userId}")
    @ResponseBody
    public JSONObject checkId(HttpServletRequest req, @PathVariable("userId") String userId) {
        //파라미터는 form태그처럼 페이지 이동으로 받을때, pathVariable은 페이지이동 없는 ajax로 받을때. @ResponseBody 줘야함
        JSONObject obj = new JSONObject();
        if (userService.checkId(userId)) {
            obj.put("status", "not-ok");
        } else {
            obj.put("status", "ok");
        }
        return obj;
    }

    //이메일 중복검사
    @GetMapping("/manage/EmailCheck/{userEmail}")
    @ResponseBody
    public JSONObject checkEmail(HttpServletRequest req, @PathVariable("userEmail") String userEmail) {
        //파라미터는 form태그처럼 페이지 이동으로 받을때, pathVariable은 페이지이동 없는 ajax로 받을때. @ResponseBody 줘야함
        JSONObject obj = new JSONObject();
        if (userService.checkEmail(userEmail)) {
            obj.put("status", "not-ok");
        } else {
            obj.put("status", "ok");
        }
        return obj;
    }


    //단순페이지 이동
//    @GetMapping("manage/userSelect")
//    public void userSelect(){
//    }


    @GetMapping("/manage/userJoin")
    public void userJoin() {
    }

    @GetMapping("/manage/userLogin")
    public void userLogin() {
    }

    @GetMapping("/manage/userFindId")
    public void userFindId(){}

    @GetMapping("/manage/userFindPw")
    public void userFindPw(){}

    @GetMapping("/manage/userNewPw")
    public void userNewPw(String id, Model model){
        model.addAttribute("id", id);
        log.info("--------------------");
        log.info("받은아이디 : " + id);
        log.info("--------------------");

    }
}