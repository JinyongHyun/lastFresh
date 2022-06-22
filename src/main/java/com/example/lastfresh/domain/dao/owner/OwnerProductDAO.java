package com.example.lastfresh.domain.dao.owner;


import com.example.lastfresh.domain.dto.BillSoldProductDTO;
import com.example.lastfresh.domain.dto.ProductDTO;
import com.example.lastfresh.domain.dto.ProductListDTO;
import com.example.lastfresh.mapper.owner.OwnerProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OwnerProductDAO {
    private final OwnerProductMapper ownerproductMapper;

//    public List<ProductListDTO> getList(Criteria criteria) {return ownerproductMapper.getList(criteria);}
    public List<ProductListDTO> getList(HashMap<String,Object> map) {return ownerproductMapper.getList(map);}

//    public int getTotal(Criteria criteria) {return ownerproductMapper.getTotal(criteria);}
    public int getTotal(HashMap<String,Object> map) {return ownerproductMapper.getTotal(map);}

    /*상품 삭제*/
    public boolean deleteProductMenu(Long sellProductNum) {return ownerproductMapper.deleteProductMenu(sellProductNum) == 1;}
    
    /*상품 하나의 총 정보*/
    public ProductDTO getListAll(Long sellProductNum) {return ownerproductMapper.getListAll(sellProductNum);}
    
    /*판매된 상품 총 목록*/
    public List<BillSoldProductDTO> getListSold(HashMap<String, Object> map) {return ownerproductMapper.getListSold(map);}
    
    /*판맨된 상품 총 개수*/
    public int getTotalSold(HashMap<String,Object> map) {return ownerproductMapper.getTotalSold(map);}

    /* 마감기한 지난 상품 자동 업데이트*/
    public void updateExpireProduct() {ownerproductMapper.updateExpireProduct();}

    public List<ProductDTO> getOldFiles () {return ownerproductMapper.getOldFiles();}
}













