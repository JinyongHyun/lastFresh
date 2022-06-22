package com.example.lastfresh.domain.dao.user;


import com.example.lastfresh.domain.dto.BasketDTO;
import com.example.lastfresh.domain.dto.OrderDTO;
import com.example.lastfresh.domain.vo.BillVO;
import com.example.lastfresh.mapper.user.BillMapper;
import com.example.lastfresh.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BillDAO {
    private final BillMapper billMapper;

    public void insertBill(OrderDTO orderDTO){
        billMapper.insertBill(orderDTO);
    };

    public void insertBillProduct(Long userNum){
        int orderNum = billMapper.getLastOrderNum();
        billMapper.insertBillProduct(userNum, orderNum);
    };
    public void cancelOrder(Long billProductNum){billMapper.cancelOrder(billProductNum);}

    public void addStock(Long sellProductNum, Long quantity){billMapper.addStock(sellProductNum, quantity);}

  /*  public List<BillVO> getOrders(Long userNum){return billMapper.getOrders(userNum);}
*/


    //insertBillProduct
//    public  getList( ) {}

//    public  get( ) {}

}













