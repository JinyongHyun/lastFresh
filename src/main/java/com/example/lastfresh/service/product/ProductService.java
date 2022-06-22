package com.example.lastfresh.service.product;

import com.example.lastfresh.domain.dao.product.ProductDAO;
import com.example.lastfresh.domain.dto.ProductDTO;
import com.example.lastfresh.domain.repository.BasketRepository;
import com.example.lastfresh.domain.repository.ProductRepository;
import com.example.lastfresh.domain.repository.UserRepository;
import com.example.lastfresh.domain.vo.BasketVO;
import com.example.lastfresh.domain.vo.CriteriaProduct;
import com.example.lastfresh.domain.vo.ProductVO;
import com.example.lastfresh.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService{
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final BasketRepository basketRepository;

    private final ProductDAO productDAO;

    public List<ProductVO> proAddressListPickup(HashMap<String, Object> map) {
        return productDAO.proAddressListPickup(map);
    }

    public int getTotalProListPickup(HashMap<String, Object> map) {
        return productDAO.getTotalProListPickup(map);
    }
    public List<ProductVO> proAddressListList(HashMap<String, Object> map) {
        return productDAO.proAddressListList(map);
    }

    public int getTotalAddressCategory(HashMap<String, Object> map) {
        return productDAO.getTotalAddressCategory(map);
    }

    public List<ProductVO> getCategoryList( HashMap<String, Object> categoryMap) {
        return productDAO.getCategoryList(categoryMap);
    }
    public int getTotalCategory(HashMap<String, Object> categoryMap) {
        return productDAO.getTotalCategory(categoryMap);
    }

    //    카테고리 가져오기
    public Long getCategoryNum(String categoryName) {
        Long categoryNum = productDAO.getCategoryNum(categoryName);
        log.info("카테고리넘버 서비스 들어옴"+categoryNum);
        return categoryNum;
    }


    // 신상품 상품 목록
    public List<ProductVO> getList(HashMap<String,Object> map) {
        return productDAO.getList(map);
//        List<ProductVO> products = productRepository.findAll();
//        return products;
    }
    // 해당 게시글 가져오기
    public ProductDTO get(Long sellProductNum) {
        return productDAO.get(sellProductNum);
    }
    // 신상품 상품 전체 갯수
    public int getTotal(CriteriaProduct criteriaProduct) {
        return productDAO.getTotal(criteriaProduct);
    }
    // 픽업 상품 목록
    public List<ProductVO> getPickupList(HashMap<String,Object> map) {
        return productDAO.getPickupList(map);
    }
    // 픽업 상품 전체 갯수
    public int getPickupTotal(CriteriaProduct criteriaProduct) {
        return productDAO.getPickupTotal(criteriaProduct);
    }
    // 배달 상품 목록
    public List<ProductVO> getDeliveryList(HashMap<String,Object> map) {
        return productDAO.getDeliveryList(map);
    }
    // 배달 상품 전체 갯수
    public int getDeliveryTotal(CriteriaProduct criteriaProduct) {
        return productDAO.getDeliveryTotal(criteriaProduct);
    }

    // 배송 상품 목록
    public List<ProductVO> getShippingList(HashMap<String,Object> map) {
        return productDAO.getShippingList(map);
    }
    // 배송 상품 전체 갯수
    public int getShippingTotal(CriteriaProduct criteriaProduct) {
        return productDAO.getShippingTotal(criteriaProduct);
    }


    //창환
    //새상품 목록
    public List<ProductVO> getListByNew() {
        //when
        PageRequest pageRequest = PageRequest.of(0,4, Sort.by(Sort.Direction.DESC,"sellProductNum"));

        Page<ProductVO> page = productRepository.findAllByOrderBySellProductNumDesc(pageRequest);

        //then
        List<ProductVO> content = page.getContent(); //조회된 데이터
        return content;
    }

    //마감 상품 목록
    @Query("select products from ProductVO products where products.sellProductExpireDay= current_date ")
    public List<ProductVO> getListBySale() {
        //when
        PageRequest pageRequest = PageRequest.of(0,2,Sort.by(Sort.Direction.DESC,"sellProductExpireDay"));

        Page<ProductVO> page = productRepository.findAllByOrderBySellProductExpireDayDesc(pageRequest);

        //then
        List<ProductVO> content = page.getContent(); //조회된 데이터
        return content;
    }

    //후기 많은 상품 목록(myBatis로 구현됨)
    public  List<ProductVO> getListByReview(){
        List<ProductVO> products=productDAO.getListByReview();
        return products;
    }

    //이미지
    public  List<ProductVO> getImages(Long pno){ return productDAO.getImages(pno);}

    //상품 담기
    public  void productToBasket(Long userNum, BasketVO basketVO,ProductVO productVO){
        log.info(userNum + "userNum +++++++++++++++++++++++++++++++++++++++" );
        log.info(basketVO.toString() + "basketVO +++++++++++++++++++++++++++++++++++++++" );
        log.info(productVO.toString() + "productVO +++++++++++++++++++++++++++++++++++++++" );
        Long basketQuantity = basketVO.getBasketQuantity();
        Long sellProductNum = productVO.getSellProductNum();
        String basketDeliveryMethod = basketVO.getBasketDeliveryMethod();
        if (productDAO.checkExistenceBasket(userNum, productVO.getSellProductNum(), basketDeliveryMethod) != 0){ // basket is already existed
            productDAO.addQuantityToBasket(basketQuantity, userNum, sellProductNum, basketDeliveryMethod);
        }else{
            UserVO userVO = userRepository.findById(userNum).get();
            basketVO.setProductVO(productVO);
            basketVO.setUserVO(userVO);
            basketVO.setBasketGoOrder(0L);
            basketVO.setBasketGoOrder(1L);
            basketRepository.save(basketVO);
        }

    }

}

