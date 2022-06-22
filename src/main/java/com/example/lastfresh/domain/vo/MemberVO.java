package com.example.lastfresh.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// @Entity
// JPA에서 관리하도록 설정하는 어노테이션
// 해당 클래스를 Mapping할 때 Entity명을 사용하게 되며, 이는 name 속성에 설정한다.
// 만약 name 속성을 생략하면 클래스명이 Entity명으로 사용된다.
@Entity
// @Table
// Mapping할 테이블을 지정한다.
@Table(name = "TBL_MEMBER")
@Getter // Setter를 사용하는 것 보다 Builder Pattern을 사용하는 것이 객체의 일관성에 더 좋다(Setter로 초기화를 하면, 아직 다 초기화되지 않은 상태에서 객체가 만들어지기 때문)
@ToString
@NoArgsConstructor // JPA의 Entity를 사용할 때에는 기본 생성자가 반드시 필요하다.
public class MemberVO {
    @Id // Primary Key인 필드에 작성한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_NUMBER")
    private Long memberNumber;
    @Column(name = "MEMBER_ID")
    private String memberId;
    @Column(name = "MEMBER_NAME")
    private String memberName;
    @Column(name = "MEMBER_BIRTH")
    private Date memberBirth;

    @Builder
    public MemberVO(Long memberNumber, String memberId, String memberName, String memberBirth) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.memberNumber = memberNumber;
        this.memberId = memberId;
        this.memberName = memberName;
        try {this.memberBirth = sdf.parse(memberBirth);} catch (ParseException e) {;}
    }
}













