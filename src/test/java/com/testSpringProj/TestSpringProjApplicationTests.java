package com.testSpringProj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.testSpringProj.bean.Like;
import com.testSpringProj.bean.User;
import com.testSpringProj.exceptions.ResourceNotFoundException;
import com.testSpringProj.repository.LikeRepo;
import com.testSpringProj.repository.UserRepo;

@SpringBootTest
class TestSpringProjApplicationTests {
	
	@Autowired
	static
	LikeRepo likeRepo;
	
	@Autowired
	static
	UserRepo userRepo;

	@Test
	void contextLoads() {
		
		User user = userRepo.findById(4)
				.orElseThrow(()->new ResourceNotFoundException("User", " userId ", 4));
		
		List<Like> likeArr = likeRepo.findByUser(user);
		
		for(Like like : likeArr) {
			System.out.println("inside for like : " + like.getUser().getId());
			Integer userIdInDB = like.getUser().getId();
			if(userIdInDB==4) System.out.println(like.getLikeId());
		}
		
	}

}


