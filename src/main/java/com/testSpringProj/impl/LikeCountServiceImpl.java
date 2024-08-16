package com.testSpringProj.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testSpringProj.bean.LikeCount;
import com.testSpringProj.bean.Post;
import com.testSpringProj.exceptions.ResourceNotFoundException;
import com.testSpringProj.payloads.LikeCountDto;
import com.testSpringProj.repository.LikeCountRepo;
import com.testSpringProj.repository.PostRepo;
import com.testSpringProj.service.LikeCountService;

@Service
public class LikeCountServiceImpl implements LikeCountService {
	
	@Autowired
	LikeCountRepo likeCountRepo;
	
	@Autowired
	PostRepo postRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public LikeCountDto getLikeCount(int postId) {
		
		LikeCount likeCount = this.likeCountRepo.findById(postId).orElseThrow(
				()->new ResourceNotFoundException("LikeCountId", "LikeCount", postId));
		
		return this.modelMapper.map(likeCount, LikeCountDto.class);
	}

	@Override
	public LikeCountDto createLikeCount(LikeCountDto likeCountDto) {
		
		int postId = likeCountDto.getPostId();
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("postId", "Post", postId));
		System.out.println(likeCountDto.getLikeCount());
		LikeCount likeCount = this.modelMapper.map(likeCountDto, LikeCount.class);
		likeCount.setPost(post);
		LikeCount savedLikeCount = this.likeCountRepo.save(likeCount);
		return this.modelMapper.map(savedLikeCount, LikeCountDto.class);
	}

	@Override
	public LikeCountDto updateLikeCount(LikeCountDto likeCountDto) {
		
		int postId = likeCountDto.getPostId();
		
		LikeCount likeCount = this.likeCountRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("likeCount", "likeCountId", postId));
		likeCount.setLikeCount(likeCountDto.getLikeCount());
		LikeCount savedLikeCount = this.likeCountRepo.save(likeCount);
		return this.modelMapper.map(savedLikeCount, LikeCountDto.class);
	}

}
