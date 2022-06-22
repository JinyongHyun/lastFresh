package com.example.lastfresh.domain.dao.user;


import com.example.lastfresh.domain.dto.BasketDTO;
import com.example.lastfresh.domain.vo.BasketVO;
import com.example.lastfresh.mapper.user.BasketMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BasketDAO {
    private final BasketMapper basketMapper;

    public List<BasketVO> getListByUserNum(Long userNum) {return basketMapper.getListByUserNum(userNum);}
    public List<BasketDTO> getListByDTO(Long userNum){return basketMapper.getListByDTO(userNum);}
    public List<BasketDTO> getListPickUp(Long userNum){return basketMapper.getListPickUp(userNum);}
    public List<BasketDTO> getListDelivery(Long userNum){return basketMapper.getListDelivery(userNum);}
    public List<BasketDTO> getListShipping(Long userNum){return basketMapper.getListShipping(userNum);}


    public void removeItems(Long userNum){basketMapper.removeItems(userNum);}

    public void decreaseStock(Long userNum){basketMapper.decreaseStock(userNum);}

    public void soldOut(){basketMapper.soldOut();}

    public void restock(){basketMapper.restock();}

    public void remove(Long basketNum){basketMapper.remove(basketNum);}

    public void removeAll(Long userNum){basketMapper.removeAll(userNum);}

    public void addQuantity(Long basketNum){basketMapper.addQuantity(basketNum);}

    public void subtractQuantity(Long basketNum){basketMapper.subtractQuantity(basketNum);}

    public void check(Long basketNum){basketMapper.check(basketNum);}

    public void checkAll(Long userNum){basketMapper.checkAll(userNum);}

    public void unCheckAll(Long userNum){basketMapper.unCheckAll(userNum);}

    public int count(Long userNum){ return basketMapper.count(userNum);}

    //  장바구니에 상품 담기
    public void insert(BasketVO basketVO){basketMapper.insert(basketVO);}

//    public  getList( ) {}
//    public void insert( ) {}
//    public  get( ) {}

}













