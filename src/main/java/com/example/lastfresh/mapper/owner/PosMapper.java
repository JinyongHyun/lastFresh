package com.example.lastfresh.mapper.owner;

import com.example.lastfresh.domain.dto.BillProductDTO;
import com.example.lastfresh.domain.dto.BillSoldProductDTO;
import com.example.lastfresh.domain.dto.PosDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PosMapper {
    /*Pos 준비중 주문 리스트 조회*/
    List<PosDTO> getPreparingList(HashMap<String, Object> map);

    /*Pos 준비중 주문 총 개수*/
    int getTotalPreparing(HashMap<String,Object> map);

    /*Pos 주문 접수시 상태 업데이트*/
    int updateBillStatus(PosDTO posDTO);

    /*Pos 픽업시 상태 업데이트*/
    int updateBillStatusPickUp(PosDTO posDTO);

    /*Pos 자가라이더 준비중 시 상태 업데이트*/
    int updateBillStatusSelfReady(PosDTO posDTO);

    /*Pos 주문 취소시  주문 상태 업데이트*/
    int updateBillStatusCancel(PosDTO posDTO);

    /*Pos 주문 취소시 상품 업데이트*/
    void updateSellStatusRestore(PosDTO posDTO);

    /*Pos 주문 취소시 상품 업데이트*/
    BillProductDTO getUserNumAndSellProductNumByBillProductNum(Long billProductListNum);
}
