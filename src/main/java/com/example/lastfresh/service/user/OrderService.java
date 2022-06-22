package com.example.lastfresh.service.user;

import com.example.lastfresh.domain.dao.user.BasketDAO;
import com.example.lastfresh.domain.dao.user.BillDAO;
import com.example.lastfresh.domain.dao.user.UserDAO;
import com.example.lastfresh.domain.dto.OrderDTO;
import com.example.lastfresh.domain.repository.BasketRepository;
import com.example.lastfresh.domain.repository.UserRepository;
import com.example.lastfresh.domain.dto.BasketDTO;
import com.example.lastfresh.domain.vo.BasketVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final UserDAO userDAO;
    private final BasketDAO basketDAO;
    private final BillDAO billDAO;
    private final BasketRepository basketRepository;
    private final UserRepository userRepository;

    public List<BasketVO> getListByUserNum(Long userNum) {
        //return basketDAO.getListByUserNum(userNum);
        //return userRepository.getById(userNum).getBaskets();

        return userRepository.getById(userNum).getBaskets();

       /* UserVO userVO = userRepository.findById(userNum).get();
        userVO.setUserNum(userNum);
        return userVO;*/

    }

    public List<BasketDTO> getListByDTO(Long userNum) throws Exception {
        return basketDAO.getListByDTO(userNum);
    }


    public void insert(OrderDTO orderDTO, Long userNum){

        billDAO.insertBill(orderDTO);
        billDAO.insertBillProduct(userNum);
        basketDAO.decreaseStock(userNum);
        basketDAO.soldOut();
        basketDAO.removeItems(userNum);

    }


/*
    public List<BasketVO> getListOrder(Long userNum){
      //  basketRepository.findById(1L).get()
        return this.basketRepository.findByUserNumAndBasketGoOrder(userNum, 1L);
    }*/

}
