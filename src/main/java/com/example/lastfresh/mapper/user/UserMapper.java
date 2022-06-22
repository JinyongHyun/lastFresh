package com.example.lastfresh.mapper.user;

import com.example.lastfresh.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //로그인
    public Long login(String userId, String userPw);

    //복호화
    public String decryption(String userId);
}

