package com.example.lastfresh.mapper.rider;

import com.example.lastfresh.domain.dto.BillProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RiderMapper {
    //     목록
    public List<BillProductDTO> getBillProductInfo();
    public List<BillProductDTO> getBillProductMyInfo(Long userNum);

    //    접수상태 변화
    public void upDateStatusToFour(BillProductDTO billProductDTO);
    public void upDateStatusToTwo(BillProductDTO billProductDTO);
    public void upDateStatusToThree(BillProductDTO billProductDTO);
    public void upDateStatusToMinus(BillProductDTO billProductDTO);
    // 필터 목록
    public List<BillProductDTO> selectFilter(String sellProductAddress);

}

