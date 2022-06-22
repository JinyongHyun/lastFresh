package com.example.lastfresh.domain.dao.user;


import com.example.lastfresh.domain.vo.UserVO;
import com.example.lastfresh.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

    public Long login(String userId, String userPw) {return userMapper.login(userId, userPw);}
    public String decryption(String userId) {return userMapper.decryption(userId);}




//    public  getList( ) {}
//    public void register( ) {}
//    public boolean modify( ) {}
//    public boolean remove( ) {}
//    public  get( ) {}
}
