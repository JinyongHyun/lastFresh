package com.example.lastfresh.domain.dao.owner;

import com.example.lastfresh.domain.dto.BillProductDTO;
import com.example.lastfresh.domain.dto.PosDTO;
import com.example.lastfresh.mapper.owner.PosMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PosDAO {
    private final PosMapper posMapper;

    /*Pos 준비중 주문 리스트 조회*/
    public List<PosDTO> getPreparingList(HashMap<String, Object> map){return posMapper.getPreparingList(map);}

    /*Pos 준비중 주문 총 개수*/
    public int getTotalPreparing(HashMap<String,Object> map){return posMapper.getTotalPreparing(map);}
    
    /*Pos 주문 접수 시 쿠킹타임 및 스테이터스 변경*/
    public int updateBillStatusCancel(PosDTO posDTO){return posMapper.updateBillStatusCancel(posDTO);}

    /*Pos 픽업 시 스테이터스 변경*/
    public int updateBillStatusPickUp(PosDTO posDTO){return posMapper.updateBillStatusPickUp(posDTO);}

    /*Pos 자가라이더 준비중 시 스테이터스 변경*/
    public int updateBillStatusSelfReady(PosDTO posDTO){return posMapper.updateBillStatusSelfReady(posDTO);}

    /*Pos 주문 취소 시 주문 스테이터스 변경*/
    public int updateBillStatus(PosDTO posDTO){return posMapper.updateBillStatus(posDTO);}

    /*Pos 주문 취소 시 상품 스테이터스, 수량 변경*/
    public void updateSellStatusRestore(PosDTO posDTO){posMapper.updateSellStatusRestore(posDTO);}

    /*Pos 주문 취소 시 상품 스테이터스, 수량 변경*/
    public BillProductDTO getUserNumAndSellProductNumByBillProductNum(Long billProductListNum){return posMapper.getUserNumAndSellProductNumByBillProductNum(billProductListNum);}
}
