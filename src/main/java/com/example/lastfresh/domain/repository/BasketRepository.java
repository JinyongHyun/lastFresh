package com.example.lastfresh.domain.repository;

import com.example.lastfresh.domain.vo.BasketVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BasketRepository extends JpaRepository<BasketVO, Long> {

   /* public List<BasketVO> findByUserNumAndBasketGoOrder(Long userNum, Long basketGoOrder);*/
}
