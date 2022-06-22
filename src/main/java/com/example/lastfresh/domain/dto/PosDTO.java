package com.example.lastfresh.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class PosDTO {
    private Long billProductListNum;
    private Long sellProductNum;
    private Long billOrderNum;
    private Long userNum;
    private Long billProductQuantity;
    private Long billProductPrice;
    private String billDeliveryMethod;
    private String billStatus;
    private Long billCookingTime;
    private String billOrderDate;
    private String billOrderDateTime;
    private String billDeliveryAddress;
    private String billDeliveryAddressDetail;
    private String billDeliveryAddressPostNum;
    private String sellProductDeliveryMethod;
    private String sellProductShippingMethod;
    private String sellProductPickup;
    private String sellProductName;
    private String userPhone;
    private Long sellUserNum;
}
