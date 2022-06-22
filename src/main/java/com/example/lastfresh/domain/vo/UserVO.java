package com.example.lastfresh.domain.vo;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_USER")
@Getter
@Setter
@ToString( exclude = {"basketVO", "productVO", "ReviewVO"})
//@NoArgsConstructor
public class UserVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_NUM")
    private Long userNum;
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "USER_PW")
    private String userPw;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "USER_EMAIL")
    private String userEmail;
    @Column(name = "USER_ADDRESS")
    private String userAddress;
    @Column(name = "USER_ADDRESS_DETAIL")
    private String userAddressDetail;
    @Column(name = "USER_ADDRESS_POST_NUM")
    private String userAddressPostNum;
    @Column(name = "USER_PHONE")
    private String userPhone;
    @Column(name = "USER_KAKAO")
    private String userKakao;
    /* 1. 판매자, 2. 회원, 3. 라이더, -1. 탈퇴*/
    @Column(name = "USER_STATUS")
    private String userStatus;

    //basket many to many
    @OneToMany(mappedBy = "userVO") // 다대다
    List<BasketVO> baskets = new ArrayList<>();
   // private List<Baskes = new ArrayList<>();

    @OrderBy("REVIEW_NUM DESC")
    @OneToMany(mappedBy = "userVO") // 다대다
    List<ReviewVO> reviews = new ArrayList<>();

    @OrderBy("BILL_ORDER_NUM DESC")
    @OneToMany(mappedBy = "userVO") // 다대다
    List<BillVO> bills = new ArrayList<>();

    public void updateAll(String userPw, String userName, String userEmail, String userAddress, String userAddressDetail, String userAddressPostNum, String userPhone, String userKakao, String userStatus){
        this.userPw = userPw;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userAddressDetail = userAddressDetail;
        this.userAddressPostNum = userAddressPostNum;
        this.userPhone = userPhone;
        this.userKakao = userKakao;
        this.userStatus = userStatus;
    }

    public void updateUserStatus(String userStatus){
        this.userStatus = userStatus;
    }


    @Builder
    public UserVO(Long userNum, String userId, String userPw, String userName, String userEmail, String userAddress, String userAddressDetail, String userAddressPostNum, String userPhone, String userKakao, String userStatus) {
        this.userNum = userNum;
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userAddressDetail = userAddressDetail;
        this.userAddressPostNum = userAddressPostNum;
        this.userPhone = userPhone;
        this.userKakao = userKakao;
        this.userStatus = userStatus;
    }
    public UserVO() {;}
}
