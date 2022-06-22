package com.example.lastfresh.service.rider;

import com.example.lastfresh.domain.dao.rider.RiderDAO;
import com.example.lastfresh.domain.dto.BillProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderService {
//    @Autowired
//    private BillProductRepository billProductRepository;
    @Autowired
    private RiderDAO riderDAO;
    //목록
    public List<BillProductDTO> getList(){return riderDAO.getList();}
    public List<BillProductDTO> getMyList(Long userNum){return riderDAO.getMyList(userNum);}
    //접수 상태 변화
    public void upDateStatusToFour(BillProductDTO billProductDTO) {riderDAO.upDateStatusToFour(billProductDTO);}
    public void upDateStatusToTwo(BillProductDTO billProductDTO) {riderDAO.upDateStatusToTwo(billProductDTO);}
    public void upDateStatusToThree(BillProductDTO billProductDTO) {riderDAO.upDateStatusToThree(billProductDTO);}
    public void upDateStatusToMinus(BillProductDTO billProductDTO) {riderDAO.upDateStatusToMinus(billProductDTO);}
    // 필터 목록
    public List<BillProductDTO> selectFilter(String sellProductAddress){return riderDAO.selectFilter(sellProductAddress);}

}
