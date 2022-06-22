package com.example.lastfresh.mapper.owner;

import com.example.lastfresh.domain.dto.BillSoldProductDTO;
import com.example.lastfresh.domain.dto.ProductDTO;
import com.example.lastfresh.domain.dto.ProductListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OwnerProductMapper {
    //    게시글 목록
    List<ProductListDTO> getList(HashMap<String,Object> map);

    //    전체 게시글 개수
    int getTotal(HashMap<String,Object> map);

    //      메뉴 삭제
    int deleteProductMenu(Long sellProductNum);

    // 프로덕트 넘버로 상품 조회
    ProductDTO getListAll(Long sellProductNum);

    // 배송 완료된 판매 상품 리스트 조회
    List<BillSoldProductDTO> getListSold(HashMap<String, Object> map);

    // 배송 완료된 판매 총 개수
    int getTotalSold(HashMap<String,Object> map);

    // 마감기한 지난 상품 업데이트
    void updateExpireProduct();

    // 어제 날짜 ProductDTO 조회
    List<ProductDTO> getOldFiles();
}

