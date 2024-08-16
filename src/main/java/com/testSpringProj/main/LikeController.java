package com.testSpringProj.main;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.vote.ConsensusBased;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testSpringProj.payloads.LikeDto;
import com.testSpringProj.service.LikeService;

@RestController
@RequestMapping("api/likes")
public class LikeController {
	
	@Autowired
	LikeService likeService;
	
	@GetMapping("/{likeId}")
	public LikeDto getLikeById(@PathVariable("likeId") Integer likeId) {
		System.out.println("like id is : " + likeId);
		LikeDto likeDto = this.likeService.getLikeById(likeId);
				
		return likeDto;
	}
	
	@PutMapping("/{likeId}")
	public LikeDto updateLike(@PathVariable Integer likeId, 
			@RequestParam("count") Integer likes, 
			@RequestParam("userId") Integer userId,
			@RequestParam("postId") Integer postId,
			@RequestParam("likeCheck") boolean isLiked) {

		LikeDto res = this.likeService.updateLike(likes, likeId, userId, postId, isLiked);
		
		return res;
	}
	
	@PostMapping("/user/{userId}/post/{postId}")
	public LikeDto createLike(@PathVariable Integer userId,
			@PathVariable Integer postId,
			@RequestParam("count") Integer likes) {
	
	LikeDto res = this.likeService.createLike(userId, postId, likes, false, false);
	
	return res;
	}

}
 