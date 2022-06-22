package com.example.lastfresh.mapper.user;

import com.example.lastfresh.domain.dto.BasketDTO;
import com.example.lastfresh.domain.vo.BasketVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BasketMapper {
    //    userNum 별 게시글 목록
    public List<BasketVO> getListByUserNum(Long userNum);

    public List<BasketDTO> getListByDTO(Long uerNum);

    public List<BasketDTO> getList(Long uerNum);

    public List<BasketDTO> getListPickUp(Long uerNum);

    public List<BasketDTO> getListDelivery(Long uerNum);

    public List<BasketDTO> getListShipping(Long uerNum);

    public void removeItems(Long userNum);

    public void decreaseStock(Long userNum);

    public void soldOut();

    public void restock();

    public void remove(Long basketNum);

    public void removeAll(Long userNum);

    public void addQuantity(Long basketNum);

    public void subtractQuantity(Long basketNum);

    public void check(Long basketNum);

    public void checkAll(Long userNum);

    public void unCheckAll(Long userNum);

    public int count(Long userNum);

    //  장바구니에 상품 담기
    public void insert(BasketVO basketVO);

//
//    //    사기

//    public void insert(String hi);
//
//
//    //    특정 글 가져오기
//    public  get( );
}

