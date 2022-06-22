package com.example.lastfresh.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@Data
@Entity
@Table(name = "TBL_BASKET")
@Getter
@Setter
@ToString(of={"basketNum", "basketQuantity", "basketDeliveryMethod", "basketGoOrder"})
@NoArgsConstructor
public class BasketVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BASKET_NUM")
    private Long basketNum;
    @Column(name = "BASKET_QUANTITY")
    private Long basketQuantity;
    /*1픽업 2배달 3배송*/
    @Column(name = "BASKET_DELIVERY_METHOD")
    private String basketDeliveryMethod;
    /* 0주문선택X, 1주문선택O */
    @Column(name = "BASKET_GO_ORDER")
    private Long basketGoOrder;
    /*총 금액*/
    @Column(name = "BASKET_PRICE")
    private Long basketPrice;

    @ManyToOne // 다대일
    @JoinColumn(name = "USER_NUM")
    private UserVO userVO;

    @ManyToOne // 다대일
    @JoinColumn(name = "SELL_PRODUCT_NUM")
/*    @JoinTable(name = "BASKET_PRODUCT", //조인테이블명
            joinColumns = @JoinColumn(name="BASKET_SELL_PRODUCT_NUM"),  //외래키
            inverseJoinColumns = @JoinColumn(name="SELL_PRODUCT_NUM") //반대 엔티티의 외래키
    )*/
    private ProductVO productVO;


    @Builder
    public BasketVO(Long basketNum, Long basketQuantity, String basketDeliveryMethod, Long basketGoOrder, UserVO userVO, ProductVO productVO) {
        this.basketNum = basketNum;
        this.basketQuantity = basketQuantity;
        this.basketDeliveryMethod = basketDeliveryMethod;
        this.basketGoOrder = basketGoOrder;
        this.userVO = userVO;
        this.productVO = productVO;
    }

   // public BasketVO(){;}
}
