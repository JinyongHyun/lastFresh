package com.example.lastfresh.domain.repository;

import com.example.lastfresh.domain.vo.BillVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<BillVO, Long> {

}
