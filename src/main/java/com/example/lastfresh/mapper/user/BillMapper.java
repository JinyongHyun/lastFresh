package com.example.lastfresh.mapper.user;

import com.example.lastfresh.domain.dto.BasketDTO;
import com.example.lastfresh.domain.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BillMapper {
    public void insertBill(OrderDTO orderDTO);

    public int getLastOrderNum();

    public void cancelOrder(Long billProductNum);

    public void addStock(Long sellProductNum, Long quantity);

    public void insertBillProduct(@Param("userNum") Long userNum, @Param("orderNum") int orderNum);

    public List<OrderDTO> getOrders(Long userNum);
//    //     목록
//    public List<> getList( );
//    //    특정 글 가져오기
//    public  get( );
}

