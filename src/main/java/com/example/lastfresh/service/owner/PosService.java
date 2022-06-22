package com.example.lastfresh.service.owner;

import com.example.lastfresh.domain.dao.owner.PosDAO;
import com.example.lastfresh.domain.dto.BillProductDTO;
import com.example.lastfresh.domain.dto.PosDTO;
import com.example.lastfresh.domain.vo.CriteriaPos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PosService {
    private final PosDAO posDAO;

    /* 준비중인 주문 리스트 조회 */
    public List<PosDTO> getListPreparing(HashMap<String,Object> map) {
        return posDAO.getPreparingList(map);
    }
    
    /* 준비중인 주문 리스트 총개수 */
    public int getTotalPreparing(HashMap<String,Object> map) {
        return posDAO.getTotalPreparing(map);
    }

    /* 주문 접수시 상태, 쿠킹타임 변경 */
    public boolean modifyBill(PosDTO posDTO) {
        return posDAO.updateBillStatus(posDTO) == 1;
    }
    
    /* 픽업 접수시 상태, 주문 상태 변경 */
    public boolean modifyBillPickUp(PosDTO posDTO) {
        return posDAO.updateBillStatusPickUp(posDTO) == 1;
    }
    
    /* 자가라이더 준비중 시, 주문 상태 변경 */
    public boolean modifyBillSelfReady(PosDTO posDTO) {
        return posDAO.updateBillStatusSelfReady(posDTO) == 1;
    }
    
    /* 유저넘버, 상품 넘버 가져오기*/
    public BillProductDTO getNumsByBillProductListNum(Long billProductListNum) {
        return posDAO.getUserNumAndSellProductNumByBillProductNum(billProductListNum);
    }

    /* 주문 취소시 상태 변경 */
    @Transactional
    public boolean cancelBill(PosDTO posDTO) {
        posDAO.updateSellStatusRestore(posDTO);
        return posDAO.updateBillStatusCancel(posDTO) == 1;
    }
}
