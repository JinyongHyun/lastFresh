package com.example.lastfresh.service.owner;

import com.example.lastfresh.domain.dao.owner.OwnerProductDAO;
import com.example.lastfresh.domain.dao.product.ProductDAO;
import com.example.lastfresh.domain.dto.BillSoldProductDTO;
import com.example.lastfresh.domain.dto.ProductDTO;
import com.example.lastfresh.domain.dto.ProductListDTO;
import com.example.lastfresh.domain.repository.ProductRepository;
import com.example.lastfresh.domain.repository.UserRepository;
import com.example.lastfresh.domain.vo.Criteria;
import com.example.lastfresh.domain.vo.ProductVO;
import com.example.lastfresh.domain.vo.ProductVO2;
import com.example.lastfresh.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OwnerService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final OwnerProductDAO ownerProductDAO;

//    public void register(ProductDTO productDTO, Long userNum) {
//        log.info("--------------------------------------------------");
//        log.info("DTO :" + productDTO);
//        log.info("--------------------------------------------------");
//
//        ProductVO productVO = new ModelMapper().map(productDTO, ProductVO.class);
////        UserVO userVO = userRepository.findById(userNum).get();
////        productVO.setUserVO(userVO);
//
//
//
//        productRepository.save(productVO);
//    }

    /*메뉴 등록하기*/
    public void register(ProductVO productVO, Long userNum) {
        log.info("--------------------------------------------------");
        log.info("DTO :" + productVO);
        log.info("--------------------------------------------------");

//        ProductVO productVO = modelMapper.map(productDTO, ProductVO.class);
        UserVO userVO = userRepository.findById(userNum).get();
        productVO.setUserVO(userVO);
        productRepository.save(productVO);
    }

    /*로그인한 판매자의 상품 목록 가져오기*/
//    public List<ProductListDTO> getList(Criteria criteria){
//        return ownerProductDAO.getList(criteria);
//    }
    public List<ProductListDTO> getList(HashMap<String,Object> map){
        return ownerProductDAO.getList(map);
    }

    /*로그인한 판매자의 상품 총 개수*/
    public int getTotal(HashMap<String,Object> map) {
        return ownerProductDAO.getTotal(map);
    }

    /*로그인한 판매자의 상품 delete*/
    public boolean deleteProductMenu (Long sellProductNum) {
        return ownerProductDAO.deleteProductMenu(sellProductNum);
    }

    /* productDTO By sellProductNum*/
    public ProductDTO getListAllBysSllProductNum (Long sellProductNum) {
        return ownerProductDAO.getListAll(sellProductNum);
    }
    
    /* 상품 정보 업데이트*/
    public void modify(ProductVO productVO) {
        ProductVO productVO1 = productRepository.findById(productVO.getSellProductNum()).orElseThrow(EntityNotFoundException::new);
        productVO1.setSellProductCategory(productVO.getSellProductCategory());
        productVO1.setSellProductName(productVO.getSellProductName());
        productVO1.setSellProductOriginPrice(productVO.getSellProductOriginPrice());
        productVO1.setSellProductDiscountPrice(productVO.getSellProductDiscountPrice());
        productVO1.setSellProductExpireDay(productVO.getSellProductExpireDay());
        productVO1.setSellProductStock(productVO.getSellProductStock());
        productVO1.setSellProductPickup(productVO.getSellProductPickup());
        productVO1.setSellProductDeliveryMethod(productVO.getSellProductDeliveryMethod());
        productVO1.setSellProductDeliveryAddress1(productVO.getSellProductDeliveryAddress1());
        productVO1.setSellProductDeliveryAddress2(productVO.getSellProductDeliveryAddress2());
        productVO1.setSellProductDeliveryAddress3(productVO.getSellProductDeliveryAddress3());
        productVO1.setSellProductShippingMethod(productVO.getSellProductShippingMethod());
        productVO1.setSellProductAddress(productVO.getSellProductAddress());
        productVO1.setSellProductAddressDetail(productVO.getSellProductAddressDetail());
        productVO1.setSellProductAddressPostNum(productVO.getSellProductAddressPostNum());
        productVO1.setSellProductDescription(productVO.getSellProductDescription());
        productVO1.setSellProductPhoneNum(productVO.getSellProductPhoneNum());
        productVO1.setSellProductThumbnail(productVO.getSellProductThumbnail());
        productVO1.setSellProductImage(productVO.getSellProductImage());
        productVO1.setSellProductImageUploadPath(productVO.getSellProductImageUploadPath());
        productVO1.setSellProductImageUuid(productVO.getSellProductImageUuid());
//        productRepository.save(productVO1);
    }

    /*로그인한 판매자의 판매 완료 목록 가져오기*/
    public List<BillSoldProductDTO> getListSold(HashMap<String,Object> map){
        return ownerProductDAO.getListSold(map);
    }

    /*로그인한 판매자의 판매 완료 상품 총 개수*/
    public int getTotalSold(HashMap<String,Object> map) {
        return ownerProductDAO.getTotalSold(map);
    }

    /* 어제날짜 상품 조회 */
    public List<ProductDTO> getOldFiles() {
        return ownerProductDAO.getOldFiles();
    }

    //    public PageDTO<ProductVO> getProductVOs(Pageable pageable, Long userNum) {
//        UserVO userVO = userRepository.findById(userNum).get();
//
//        Page<ProductVO> productVOPage = productRepository2.findByUserOrderByIdDesc(userVO, pageable);
//
//        PageDTO<ProductVO> pageDTO = new PageDTO<>(productVOPage);
//        return pageDTO;
//    }

}
