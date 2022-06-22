package com.example.lastfresh.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@ToString
@Getter
@Setter
public class ProductDTO {
    private Long sellProductNum;

    private Long sellProductCategory;

    private String sellProductName;

    private Long sellProductOriginPrice;

    private Long sellProductDiscountPrice;

    private String sellProductExpireDate;

    private Long sellProductStock;

    private String sellProductPickup; // 0 픽업, 1 픽업 불가

    private String sellProductDeliveryMethod;  // 0배달x, 1프레쉬라이더, 2자가라이더

    private String sellProductDeliveryAddress1;

    private String sellProductDeliveryAddress2;

    private String sellProductDeliveryAddress3;

    private String sellProductShippingMethod;  // 0배달x, 1프레쉬라이더, 2자가라이더

    private String sellProductAddress;

    private String sellProductAddressDetail;

    private String sellProductAddressPostNum;

    private String sellProductDescription;

    private String sellProductPhone;

    private String sellProductThumbnail;

    private String sellProductImage;

    private String sellProductImageUploadPath;

    private String sellProductImageUuid;

    private String userName;
}
