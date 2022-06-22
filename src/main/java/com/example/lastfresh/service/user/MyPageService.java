package com.example.lastfresh.service.user;

import com.example.lastfresh.domain.dao.user.BasketDAO;
import com.example.lastfresh.domain.dao.user.BillDAO;
import com.example.lastfresh.domain.dao.user.UserDAO;
import com.example.lastfresh.domain.repository.BillProductRepository;
import com.example.lastfresh.domain.repository.BillRepository;
import com.example.lastfresh.domain.repository.UserRepository;
import com.example.lastfresh.domain.vo.BillProductVO;
import com.example.lastfresh.domain.vo.BillVO;
import com.example.lastfresh.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyPageService {
    private final UserDAO userDAO;
    private final BillDAO billDAO;
    private final BasketDAO basketDAO;
    private final UserRepository userRepository;
    private final BillRepository billRepository;
    private final BillProductRepository billProductRepository;


    public boolean modify(UserVO userVO, Long userNum) throws Exception{
        // original userVO
        UserVO originalUserVO = userRepository.findById(userNum).get();
        originalUserVO.updateAll(userVO.getUserPw(), userVO.getUserName(), userVO.getUserEmail(), userVO.getUserAddress(), userVO.getUserAddressDetail(), userVO.getUserAddressPostNum(), userVO.getUserPhone(), userVO.getUserKakao(), userVO.getUserStatus());
        userRepository.save(userVO);

        return true;
    }

    public void exit(Long userNum){
        UserVO userVO =  userRepository.findById(userNum).get();
        userVO.updateUserStatus("-1");
        userRepository.save(userVO);
    }

    public void cancelOrder(Long billProductNum){

        Long quantity = billProductRepository.getById(billProductNum).getBillProductQuantity();
        Long sellProductNum = billProductRepository.getById(billProductNum).getProductVO().getSellProductNum();

        billDAO.cancelOrder(billProductNum);
        billDAO.addStock(sellProductNum, quantity);
        basketDAO.restock();


       // BillProductVO billProductVO = billProductRepository.findById(billProductNum).get();
       // billProductVO.updateBillStatus("-1");

        // billProductRepository.save(billProductVO);
    }

    public void cancelAll(Long billOrderNum){
        List<BillProductVO> list = billRepository.getById(billOrderNum).getProducts();
        list.forEach(billProductVO -> {
            billProductVO.updateBillStatus("-1");
            billProductRepository.save(billProductVO);
        });
    }

    public UserVO get(Long userNum) throws Exception{
      UserVO userVO = userRepository.findById(userNum).get();
      userVO.setUserNum(userNum);
      return userVO;
    }

    @Transactional
    public List<BillVO> getBills(Long userNum) throws Exception{
        List<BillVO> bills = userRepository.getById(userNum).getBills();
        return bills;
    }

    @Transactional
    public BillVO getBill(Long billOrderNum) throws Exception{
        BillVO bill = billRepository.getById(billOrderNum);
        return bill;
    }


   /* public List<BillVO> getOrders(Long userNum) throws Exception{
        return billDAO.getOrders(userNum);
    }*/

  /*
  getProductNames

  public List<BasketDTO> getListByDTO(Long userNum) throws Exception {
        return basketDAO.getListByDTO(userNum);
    }*/

}
