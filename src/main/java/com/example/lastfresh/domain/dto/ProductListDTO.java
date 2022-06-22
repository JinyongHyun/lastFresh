package com.example.lastfresh.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Getter
@Setter
@ToString
public class ProductListDTO {
    private Long sellProductNum;

    private Long userNum;

    private String sellProductName;

    private Long sellProductDiscountPrice;

    private String  sellProductExpireDate;

    private Long sellProductStock;

    private String sellProductStatus;

    private String sellProductPickup;

    private String sellProductDeliveryMethod;

    private String sellProductShippingMethod;

    private String sellProductThumbnail;

    private String sellProductImageUploadPath;
}
