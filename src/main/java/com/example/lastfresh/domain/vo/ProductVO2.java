package com.example.lastfresh.domain.vo;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Component
@Getter
@Setter
@ToString
public class ProductVO2 {
    private Long SELL_PRODUCT_NUM;

    private Long USER_NUM;

    private Long SELL_PRODUCT_CATEGORY;

    private String SELL_PRODUCT_NAME;

    private Long SELL_PRODUCT_ORIGIN_PRICE;

    private Long SELL_PRODUCT_DISCOUNT_PRICE;

    private String  SELL_PRODUCT_EXPIRE_DATE;

    private Long SELL_PRODUCT_STOCK;

    private String SELL_PRODUCT_STATUS = "0"; // 0판매가능, -1 판매 불가

    private String SELL_PRODUCT_PICKUP;

    private String SELL_PRODUCT_DELIVERY_METHOD; // 0배달x, 1프레쉬라이더, 2자가라이더

    private String SELL_PRODUCT_DELIVERY_ADDRESS1;

    private String SELL_PRODUCT_DELIVERY_ADDRESS2;

    private String SELL_PRODUCT_DELIVERY_ADDRESS3;

    private String SELL_PRODUCT_SHIPPING_METHOD; // 0배달x, 1프레쉬라이더, 2자가라이더

    private String SELL_PRODUCT_ADDRESS;

    private String SELL_PRODUCT_ADDRESS_DETAIL;

    private String SELL_PRODUCT_ADDRESS_POST_NUM;

    private String SELL_PRODUCT_DESCRIPTION;

    private String SELL_PRODUCT_PHONE;

    private String SELL_PRODUCT_THUMBNAIL;

    private String SELL_PRODUCT_IMAGE;

    private String SELL_PRODUCT_IMAGE_UPLOAD_PATH;

    private String SELL_PRODUCT_IMAGE_UUID;
}
