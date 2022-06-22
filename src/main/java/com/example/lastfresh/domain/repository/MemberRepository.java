package com.example.lastfresh.domain.repository;


import com.example.lastfresh.domain.vo.MemberVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberVO, Long> {

}
