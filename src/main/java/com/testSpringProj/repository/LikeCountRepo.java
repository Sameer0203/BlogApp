package com.testSpringProj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testSpringProj.bean.LikeCount;

public interface LikeCountRepo extends JpaRepository<LikeCount, Integer> {

}
