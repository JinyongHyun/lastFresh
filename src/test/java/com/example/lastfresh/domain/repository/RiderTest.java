package com.example.lastfresh.domain.repository;

import com.example.lastfresh.domain.dao.rider.RiderDAO;
import com.example.lastfresh.domain.vo.BillProductVO;
import com.example.lastfresh.mapper.rider.RiderMapper;
import com.example.lastfresh.service.rider.RiderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@SpringBootTest
@Slf4j
class RiderTest {
    @Autowired
    private RiderService riderService;
    @Autowired
    private RiderDAO riderDAO;
    @Autowired
    private RiderMapper riderMapper;
    @Autowired
    private BillProductRepository billProductRepository;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

//    @Test
//    public void listTest() {
//        log.info(riderMapper.getList().toString());
//    };
//    @Test
//    public void fillterlistTest() {
//        String fullAddress="서울특별시"+" "+"종로구"+" "+"청운효자동";
//        log.info(riderMapper.selectFilter(fullAddress).toString());
//    };
//    @Test
//    public void listTest(){
//        List<BillProductVO> bills= billProductRepository.findAll();
//        bills.stream().map(BillProductVO::toString).forEach(log::info);
//    }


//    @Test
//    public void productListTest() {
//        List<UserVO> user=userRepository.findAll();
//        user.stream().map(UserVO::toString).forEach(log::info);
//
//    }
//    @Test
//    @Transactional
//    public void productListTest() {
//        UserVO user=headerService.userInfo(3L);
//        log.info(String.valueOf(user));
//
//    }
//    @Test
//    public void testReadGet() throws Exception {
//        String responseURI = mockMvc.perform(MockMvcRequestBuilders.get("/header/userInfo").param("userNum", String.valueOf(3L)))
//                .andReturn().getModelAndView().getViewName();
//
//        log.info(responseURI);
//    }
}