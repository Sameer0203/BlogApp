package com.testSpringProj.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testSpringProj.bean.LikeCount;
import com.testSpringProj.payloads.LikeCountDto;
import com.testSpringProj.service.LikeCountService;

@RestController
@RequestMapping("/api/likeCount")
public class LikeCountController {
	
	@Autowired
	LikeCountService likeCountService;

	@GetMapping("post/{postId}")
	public LikeCountDto getLikeCount(@PathVariable("postId") Integer postId) {
		
		LikeCountDto likeCountDto = this.likeCountService.getLikeCount(postId);
		
		return likeCountDto;
	}
	
	@PostMapping("/create")
	public LikeCountDto createLikeCount(@RequestBody LikeCountDto likeCountDto) {
		LikeCountDto createLikeCount = this.likeCountService.createLikeCount(likeCountDto);
		return createLikeCount;
	}
	
	@PutMapping("/update")
	public LikeCountDto updateLikeCount(@RequestBody LikeCountDto likeCountDto) {
		LikeCountDto updateLikeCount = this.likeCountService.updateLikeCount(likeCountDto);
		return updateLikeCount;
	}
	
}
