package com.example.lastfresh.domain.repository;

import com.example.lastfresh.domain.vo.MemberVO;
import com.example.lastfresh.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void saveMemberTest(){
        String id ="hgd9999";
        String name = "홍길동";
        String birth = "2200-08-14";

        memberRepository.save(MemberVO.builder().memberId(id).memberName(name).memberBirth(birth).build());
    }

   @Test
    public void saveUserTest(){
        String id ="hgd9999";
        String name = "홍길동";
        String pw = "1234";
        String address1 = "123-30";
        String address2 = "서울시 성울구 서울시";
        String address3 = "2층";
        String mail = "akwnsldj1@naver.com";
        String kakao = "tpwhd15@naver.com";
        String status = "0";
        String phone = "010-5291-2978";

        userRepository.save(UserVO.builder().userId(id).userName(name).userPw(pw).userPhone(phone).userAddressPostNum(address1)
                .userAddress(address2).userAddressDetail(address3).userEmail(mail).userKakao(kakao).build());

    }
}