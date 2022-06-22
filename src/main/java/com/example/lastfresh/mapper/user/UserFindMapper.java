package com.example.lastfresh.mapper.user;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserFindMapper {
    //문자로 아이디,비밀번호 찾기
    public String selectId(String userPhone);

    //이메일로 아이디,비밀번호 찾기
    public String findId(String email);

    //비밀번호 변경
    public String changePw(String pw, String id);
}
