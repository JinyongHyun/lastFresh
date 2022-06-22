package com.example.lastfresh.service.user;

import com.example.lastfresh.domain.dao.user.UserFindDAO;
import com.example.lastfresh.domain.repository.UserFindRepository;
import com.example.lastfresh.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import net.nurigo.java_sdk.api.Message;


import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserFindService {

    private final UserFindDAO userFindDAO;
    private final UserFindRepository userFindRepository;
    private final PasswordEncoder passwordEncoder;

    public void certifiedPhoneNumber(String phoneNumber, String cerNum) {

        String api_key = "NCS8SOYJRUADOPCZ";
        String api_secret = "DBAX3AZJ0KVNL6FEPSZ2Z8ZMV3PJTPNZ";

        Message coolsms = new Message(api_key, api_secret);

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", phoneNumber);    // 수신전화번호
        params.put("from", "01055396116");    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
        params.put("type", "SMS");
        params.put("text", "LastFresh 휴대폰인증 메시지 : 인증번호는" + "[" + cerNum + "]" + "입니다.");
        params.put("app_version", "test app 2.2"); // application name and version

        try {
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }

    }
    /* 아이디,비밀번호 문자 */
    public String selectId(String userPhone){return userFindDAO.selectId(userPhone);};

    /* 아이디,비밀번호 이메일 */
    public String findId(String email) {return userFindDAO.findId(email);}

    /* 비밀번호 변경 */
    public String changePw(String pw, String id){
        String encodedPassword = passwordEncoder.encode(pw);
        pw = encodedPassword;
        return userFindDAO.changePw(pw, id);}
}
