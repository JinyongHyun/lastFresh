package com.example.lastfresh.mapper.product;

import com.example.lastfresh.domain.dto.ProductDTO;
import com.example.lastfresh.domain.vo.CriteriaProduct;
import com.example.lastfresh.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ProductMapper {
    public  List<ProductVO> proAddressListPickup(HashMap<String, Object> map);
    public int getTotalProListPickup(HashMap<String, Object> map);

    public  List<ProductVO> proAddressListList(HashMap<String, Object> map);
    public int getTotalAddressCategory(HashMap<String, Object> map);
    public  List<ProductVO> getCategoryList(HashMap<String, Object> categoryMap);
    public int getTotalCategory(HashMap<String, Object> categoryMap);
    // 카테고리 번호 구하기
    public int getCategoryNum(String categoryName);
    //   신상품 게시글 목록
    public List<ProductVO> getList(HashMap<String, Object> map);

    //    특정 게시글 가져오기
    public ProductDTO get(Long sellProductNum);

    //    신상품 게시글 전체 개수
    public int getTotal(CriteriaProduct criteriaProduct);

    //   픽업 게시글 목록
    public List<ProductVO> getPickupList(HashMap<String, Object> map);

    //    픽업 게시글 전체 개수
    public int getPickupTotal(CriteriaProduct criteriaProduct);

    //   배달 게시글 목록
    public List<ProductVO> getDeliveryList(HashMap<String, Object> map);

    //    배달 게시글 전체 개수
    public int getDeliveryTotal(CriteriaProduct criteriaProduct);

    //   배송 게시글 목록
    public List<ProductVO> getShippingList(HashMap<String, Object> map);

    //    배송 게시글 전체 개수
    public int getShippingTotal(CriteriaProduct criteriaProduct);
//
//    //    게시글에 작성된 댓글 수 수정
//    public void updateReplyCount( );

//    후기 많은 상품 목록 가져오기
      public List<ProductVO> getListByReview();
    //이미지
    public  List<ProductVO> getImages(Long pno);

    //    장바구니 유무
    public int checkExistenceBasket(Long userNum, Long sellProductNum, String basketDeliveryMethod);

    public void addQuantityToBasket(Long basketQuantity, Long userNum, Long sellProductNum, String basketDeliveryMethod);
}

