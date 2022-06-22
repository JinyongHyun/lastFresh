package com.example.lastfresh.domain.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class BasketDTO {
    private Long basketNum;
    private Long basketQuantity;
    /*1픽업 2배달 3배송*/
    private String basketDeliveryMethod;
    /* 0주문선택X, 1주문선택O */
    private Long basketGoOrder;
    private Long userNum;
    private Long sellProductNun;


    private String sellProductName;
    private Long sellProductDiscountPrice;
    private String sellProductThumbnail;
    private String sellProductImageUploadPath;
    //
    private Long sellProductStock;

    public BasketDTO(){;}

    public BasketDTO(Long basketNum, Long basketQuantity, String basketDeliveryMethod, Long basketGoOrder, Long userNum, Long sellProductNun, String sellProductName, Long sellProductDiscountPrice, String sellProductThumbnail, String sellProductImageUploadPath, Long sellProductStock) {
        this.basketNum = basketNum;
        this.basketQuantity = basketQuantity;
        this.basketDeliveryMethod = basketDeliveryMethod;
        this.basketGoOrder = basketGoOrder;
        this.userNum = userNum;
        this.sellProductNun = sellProductNun;
        this.sellProductName = sellProductName;
        this.sellProductDiscountPrice = sellProductDiscountPrice;
        this.sellProductThumbnail = sellProductThumbnail;
        this.sellProductImageUploadPath = sellProductImageUploadPath;
        this.sellProductStock = sellProductStock;
    }
}
