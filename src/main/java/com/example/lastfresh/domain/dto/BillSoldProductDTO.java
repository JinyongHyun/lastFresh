package com.example.lastfresh.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BillSoldProductDTO {
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
    private String sellProductThumbnail;
    private String sellProductImageUploadPath;
    private String billDeliveryAddress;
    private String billDeliveryAddressDetail;
    private String billDeliveryAddressPostNum;
    private String userPhone;
    private String sellProductName;
    private Long sellUserNum;
}
