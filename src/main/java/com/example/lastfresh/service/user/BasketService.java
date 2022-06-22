package com.example.lastfresh.service.user;

import com.example.lastfresh.domain.dao.user.BasketDAO;
import com.example.lastfresh.domain.dto.BasketDTO;
import com.example.lastfresh.domain.vo.BasketVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BasketService {
    private final BasketDAO basketDAO;
    //  장바구니에 상품 담기
    public void insert(BasketVO basketVO){basketDAO.insert(basketVO);}

    public List<BasketDTO> getListPickUp(Long userNum) throws Exception {
        return basketDAO.getListPickUp(userNum);
    }

    public List<BasketDTO> getListDelivery(Long userNum) throws Exception {
        return basketDAO.getListDelivery(userNum);
    }

    public List<BasketDTO> getListShipping(Long userNum) throws Exception {
        return basketDAO.getListShipping(userNum);
    }

    public void remove(Long basketNum) {
        basketDAO.remove(basketNum);
    }

    public void removeAll(Long userNum) { basketDAO.removeAll(userNum); }

    public void addQuantity(Long basketNum) {
        basketDAO.addQuantity(basketNum);
    }

    public void subtractQuantity(Long basketNum) {
        basketDAO.subtractQuantity(basketNum);
    }

    public void check(Long basketNum) {basketDAO.check(basketNum);}

    public void checkAll(Long userNum) {basketDAO.checkAll(userNum);}

    public void unCheckAll(Long userNum) {basketDAO.unCheckAll(userNum);}

    public int count(Long userNum) {return basketDAO.count(userNum);}
}
