package com.example.lastfresh.domain.dao.rider;


import com.example.lastfresh.domain.dto.BillProductDTO;
import com.example.lastfresh.mapper.rider.RiderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RiderDAO {
    private final RiderMapper riderBoardMapper;
    //목록
    public List<BillProductDTO> getList(){return riderBoardMapper.getBillProductInfo();}
    public List<BillProductDTO> getMyList(Long userNum){return riderBoardMapper.getBillProductMyInfo(userNum);}

    //접수상태 변화
    public void upDateStatusToFour(BillProductDTO billProductDTO) {riderBoardMapper.upDateStatusToFour(billProductDTO);}
    public void upDateStatusToTwo(BillProductDTO billProductDTO) {riderBoardMapper.upDateStatusToTwo(billProductDTO);}
    public void upDateStatusToThree(BillProductDTO billProductDTO) {riderBoardMapper.upDateStatusToThree(billProductDTO);}
    public void upDateStatusToMinus(BillProductDTO billProductDTO) {riderBoardMapper.upDateStatusToMinus(billProductDTO);}

    // 필터 목록
    public List<BillProductDTO> selectFilter(String sellProductAddress){return riderBoardMapper.selectFilter(sellProductAddress);}

}
