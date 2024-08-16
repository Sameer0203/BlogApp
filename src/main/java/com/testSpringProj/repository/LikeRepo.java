package com.testSpringProj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testSpringProj.bean.Like;
import com.testSpringProj.bean.User;

public interface LikeRepo extends JpaRepository<Like, Integer> {
	
	List<Like> findByUser(User user);

}
