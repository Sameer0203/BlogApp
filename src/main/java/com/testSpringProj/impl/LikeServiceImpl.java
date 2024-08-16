package com.testSpringProj.impl;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testSpringProj.bean.Like;
import com.testSpringProj.bean.Post;
import com.testSpringProj.bean.User;
import com.testSpringProj.exceptions.ResourceNotFoundException;
import com.testSpringProj.payloads.LikeCountDto;
import com.testSpringProj.payloads.LikeDto;
import com.testSpringProj.repository.LikeRepo;
import com.testSpringProj.repository.PostRepo;
import com.testSpringProj.repository.UserRepo;
import com.testSpringProj.service.LikeCountService;
import com.testSpringProj.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService {
	
	@Autowired 
	LikeRepo likeRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PostRepo postRepo;
	
	@Autowired
	LikeCountService likeCountService;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public LikeDto createLike(Integer userId, Integer postId, Integer counter, boolean isLiked, boolean isLikeCountCreated) {
		System.out.println("inside create>>>>>>>>>>>>>>>>>>>>>>>");
		User user = this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User", " userId ", userId));

		Post post = this.postRepo.findById(postId)
				.orElseThrow(()->new ResourceNotFoundException("Post", " postId ", postId));

		Like like = new Like();
//		like.setCounter(counter);
		like.setUser(user);
		like.setPost(post);
		like.setLiked(isLiked);
		
		Like save = this.likeRepo.save(like);
		
		if(!isLikeCountCreated) {
			LikeCountDto likeCountDto = new LikeCountDto();
			likeCountDto.setLikeCount(counter);
			likeCountDto.setPostId(postId);
			
			LikeCountDto createLikeCount = this.likeCountService.createLikeCount(likeCountDto);
		}
		LikeDto likeDto = this.modelMapper.map(save, LikeDto.class);
				
		return likeDto;

	}

	@Override
	public void deleteLike(Integer likeId) {
		
		Like like = this.likeRepo.findById(likeId)
				.orElseThrow(() ->new ResourceNotFoundException("Like", "LikeId", likeId));
		
		this.likeRepo.delete(like);

	}

	@Override
	public LikeDto updateLike(int likeCount, int likeId, int userId, int postId, boolean isLiked) {

		LikeCountDto likeCountDto = new LikeCountDto();
		likeCountDto.setLikeCount(likeCount);
		likeCountDto.setPostId(postId);
		
		LikeCountDto updateLikeCount = this.likeCountService.updateLikeCount(likeCountDto);
		
		if(likeId==0){
			LikeDto createLike = this.createLike(userId, postId, likeCount, isLiked, true);
			return createLike;
		}
		
		Like like = this.likeRepo.findById(likeId)
				.orElseThrow(() -> new ResourceNotFoundException("Like", "LikeId", likeId));

//		like.setCounter(likeCount);
		like.setLiked(isLiked);

		Like save = this.likeRepo.save(like);
		
		LikeDto likeDto = this.modelMapper.map(save, LikeDto.class);

		return likeDto;
	}

	@Override
	public LikeDto getLikeById(int likeId) {
		
		Like like = this.likeRepo.findById(likeId)
				.orElseThrow(() -> new ResourceNotFoundException("Like", "LikeId", likeId));
		
		LikeDto likeDto = this.modelMapper.map(like, LikeDto.class);

		return likeDto;
	}

}
