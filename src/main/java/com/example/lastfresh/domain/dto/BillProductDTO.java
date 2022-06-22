package com.example.lastfresh.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Data
@Getter
@Setter
@AllArgsConstructor
public class BillProductDTO {
    private Long billProductListNum;
    private Long billProductQuantity;
    private Long billProductPrice;
    /*1픽업 2배달 3배송*/
    private String billDeliveryMethod;
    private String billCookingTime;

    /*(0: 대기중  1:준비중(수락 시) 2:배송중 3:배송완료 -1:취소) */
    private String billStatus;

    private Long userNum;

    private Long sellProductNum;
    private String sellProductName;
    private String sellProductAddress;
    private String sellProductAddressDetail;
    private String sellProductAddressPostNum;
    private String sellProductPhone;

    private String billOrderDateTime;

    private Long billOrderNum;
    private String billDeliveryAddress;
    private String billDeliveryAddressDetail;
    private String billDeliveryAddressPostNum;


    public BillProductDTO(){;}

    public BillProductDTO(Long billProductListNum, String billStatus,Long userNum) {
        this.billProductListNum = billProductListNum;
        this.billStatus = billStatus;
        this.userNum=userNum;
    }

}
