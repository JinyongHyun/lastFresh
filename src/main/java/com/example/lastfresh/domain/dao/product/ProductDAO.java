package com.example.lastfresh.domain.dao.product;


import com.example.lastfresh.domain.dto.ProductDTO;
import com.example.lastfresh.domain.vo.CriteriaProduct;
import com.example.lastfresh.domain.vo.ProductVO;
import com.example.lastfresh.mapper.product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;

    public List<ProductVO> proAddressListPickup(HashMap<String, Object> map){return productMapper.proAddressListPickup(map);}
    public int getTotalProListPickup(HashMap<String, Object> map) {return productMapper.getTotalProListPickup(map);}

    public List<ProductVO> proAddressListList(HashMap<String, Object> map){return productMapper.proAddressListList(map);}
    public int getTotalAddressCategory(HashMap<String, Object> map) {return productMapper.getTotalAddressCategory(map);}

    public List<ProductVO> getCategoryList( HashMap<String, Object> categoryMap){return productMapper.getCategoryList(categoryMap);}
    public int getTotalCategory(HashMap<String, Object> categoryMap) {return productMapper.getTotalCategory(categoryMap);}
    // 카테고리 번호 구하기
    public Long getCategoryNum(String categoryName){return (long)productMapper.getCategoryNum(categoryName);}
    // 신상품 상품 전체 목록
    public List<ProductVO> getList(HashMap<String, Object> map) {return productMapper.getList(map);}
    // 신상품 전체 개수
    public int getTotal(CriteriaProduct criteriaProduct) {return productMapper.getTotal(criteriaProduct);}
    // 해당 상품 상세 페이지
    public ProductDTO get(Long sellProductNum) {return productMapper.get(sellProductNum);}
    // 픽업 상품 전체 목록
    public List<ProductVO> getPickupList(HashMap<String, Object> map) {return productMapper.getPickupList(map);}
    // 픽업 전체 개수
    public int getPickupTotal(CriteriaProduct criteriaProduct) {return productMapper.getPickupTotal(criteriaProduct);}
    // 배달 상품 전체 목록
    public List<ProductVO> getDeliveryList(HashMap<String, Object> map) {return productMapper.getDeliveryList(map);}
    // 배달 전체 개수
    public int getDeliveryTotal(CriteriaProduct criteriaProduct) {return productMapper.getDeliveryTotal(criteriaProduct);}

    // 배송 상품 전체 목록
    public List<ProductVO> getShippingList(HashMap<String, Object> map) {return productMapper.getShippingList(map);}
    // 배송 전체 개수
    public int getShippingTotal(CriteriaProduct criteriaProduct) {return productMapper.getShippingTotal(criteriaProduct);}

    // 마감 세일 상품 목록 가져오기
    public  List<ProductVO> getListByReview(){return productMapper.getListByReview();};
    //이미지
    public  List<ProductVO> getImages(Long pno){ return productMapper.getImages(pno);}

    public int checkExistenceBasket(Long userNum, Long sellProductNum, String basketDeliveryMethod){return productMapper.checkExistenceBasket(userNum, sellProductNum, basketDeliveryMethod);}

    public void addQuantityToBasket(Long basketQuantity, Long userNum, Long sellProductNum, String basketDeliveryMethod){productMapper.addQuantityToBasket(basketQuantity, userNum, sellProductNum, basketDeliveryMethod);}
}
