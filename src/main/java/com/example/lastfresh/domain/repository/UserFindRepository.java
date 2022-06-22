package com.example.lastfresh.domain.repository;

import com.example.lastfresh.domain.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFindRepository extends JpaRepository<UserVO, Long> {

}
