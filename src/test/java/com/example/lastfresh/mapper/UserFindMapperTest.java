package com.example.lastfresh.mapper;

import com.example.lastfresh.mapper.user.UserFindMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserFindMapperTest {

    @Autowired
    private UserFindMapper userFindMapper;

    @Test
    public void testSelectId(){userFindMapper.selectId("010-5539-6116");}
}
