package com.example.lastfresh.domain.vo;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TBL_BILLS")
@Getter
@Setter
@ToString(of={"billOrderNum", "billDeliveryAddress", "billDeliveryAddressDetail", "billDeliveryAddressPostNum", "billTotalPrice", "billOrderDate"})
@NoArgsConstructor
public class BillVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BILL_ORDER_NUM")
    private Long billOrderNum;
    @Column(name = "BILL_DELIVERY_ADDRESS")
    private String billDeliveryAddress;
    @Column(name = "BILL_DELIVERY_ADDRESS_DETAIL")
    private String billDeliveryAddressDetail;
    @Column(name = "BILL_DELIVERY_ADDRESS_POST_NUM")
    private String billDeliveryAddressPostNum;
    @Column(name = "BILL_TOTAL_PRICE")
    private Long billTotalPrice;
    @Column(name = "BILL_ORDER_DATE")
    private Date billOrderDate;

    @ManyToOne // 다대일
    @JoinColumn(name = "USER_NUM")
    private UserVO userVO;

    @OneToMany(mappedBy = "billVO")
    List<BillProductVO> products = new ArrayList<>();

    @Builder
    public BillVO(Long billOrderNum, String billDeliveryAddress, String billDeliveryAddressDetail, String billDeliveryAddressPostNum, Long billTotalPrice, Date billOrderDate, UserVO userVO) {
        this.billOrderNum = billOrderNum;
        this.billDeliveryAddress = billDeliveryAddress;
        this.billDeliveryAddressDetail = billDeliveryAddressDetail;
        this.billDeliveryAddressPostNum = billDeliveryAddressPostNum;
        this.billTotalPrice = billTotalPrice;
        this.billOrderDate = billOrderDate;
        this.userVO = userVO;
    }
}
