package com.example.lastfresh.domain.repository;

import com.example.lastfresh.domain.vo.ReviewVO;
import com.example.lastfresh.domain.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserVO, Long> {
    UserVO findByUserId(String userId);
    UserVO findByUserKakao(String userKakao);

    UserVO findByUserNum(Long userNum);

    //List<ReviewVO> getReviewsOrderByIdDescEmailAsc();

    //findById의 Id는 디비 테이블의 pk값 즉 vo에 적혀있는 id값
    //findBy 뒤에 컬럼명을 적으면 그 컬럼으로 비교할 수 있다.

    //ex) userVO에서 findById 사용 시
    // 쿼리문에 where user_num = #(user_num)

    // 만약에 findByUserId로 사용시
    // 쿼리문에 where user_id = #(user_id)
}