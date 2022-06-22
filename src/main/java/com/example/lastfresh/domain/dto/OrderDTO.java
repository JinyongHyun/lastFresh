package com.example.lastfresh.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderDTO {
    private Long userNum;
    private String userPhone;
    private String userEmail;
    private String userName;
    private String userAddressPostNum;
    private String userAddress;
    private String userAddressDetail;
    private int finalPrice;
    private String selector;

    public OrderDTO(){;}

    public OrderDTO(Long userNum, String userPhone, String userEmail, String userName, String userAddressPostNum, String userAddress, String userAddressDetail, int finalPrice, String selector) {
        this.userNum = userNum;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userAddressPostNum = userAddressPostNum;
        this.userAddress = userAddress;
        this.userAddressDetail = userAddressDetail;
        this.finalPrice = finalPrice;
        this.selector = selector;
    }
}
