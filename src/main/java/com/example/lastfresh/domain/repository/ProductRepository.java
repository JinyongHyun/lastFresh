package com.example.lastfresh.domain.repository;

import com.example.lastfresh.domain.vo.ProductVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductVO, Long> {
    public Page<ProductVO> findAllByOrderBySellProductNumDesc(Pageable pageable);
    public Page<ProductVO> findAllByOrderBySellProductExpireDayDesc(Pageable pageable);
}
