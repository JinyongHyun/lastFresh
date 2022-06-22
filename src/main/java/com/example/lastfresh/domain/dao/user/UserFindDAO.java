package com.example.lastfresh.domain.dao.user;

import com.example.lastfresh.domain.repository.UserFindRepository;
import com.example.lastfresh.mapper.user.UserFindMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserFindDAO {
    private final UserFindMapper userFindMapper;
    // 휴대폰 인증 ID
    public String selectId(String userPhone){return userFindMapper.selectId(userPhone);};

    //이메일 보내기
    public String findId(String email) {return userFindMapper.findId(email);}

    //비밀번호 변경
    public String changePw(String pw, String id){return userFindMapper.changePw(pw, id);}
}
