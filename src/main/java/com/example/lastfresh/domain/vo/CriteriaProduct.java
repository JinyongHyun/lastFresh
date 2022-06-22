package com.example.lastfresh.domain.vo;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
@Slf4j
public class CriteriaProduct {
   //    생성자로 초기화 시 pageNum과 amount만 초기화하기 위해서 @NonNull을 붙인다.
   @NonNull private int pageNum;
   @NonNull private int amount;
   private int limit;
   private String type;
   private String keyword;

   //   롬북을 통해 생성된 초기화 생성자를 기본 생성자에서 기본 값을 설정한 뒤 호출해준다.
   public CriteriaProduct() {this (1,6);}


   public CriteriaProduct(@NonNull int pageNum, @NonNull int amount) {
      this.pageNum = pageNum;
      this.amount = amount;
      this.limit = (pageNum - 1) * amount;

      log.info("-------------크리테리아----------------------");
      log.info("크리테리아 pageNum : " + pageNum);
      log.info("크리테리아 amount : " + amount);
      log.info("크리테리아 limit : " + this.limit);
      log.info("--------------크리테리아----------------------");

   }

   public String getListLink(){
      UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
              .queryParam("pageNum", this.pageNum)
              .queryParam("amount", this.amount);
      return builder.toUriString();
   }

}
