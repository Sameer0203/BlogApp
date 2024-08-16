package com.testSpringProj.service;

import com.testSpringProj.bean.Like;
import com.testSpringProj.payloads.LikeDto;

public interface LikeService {

	LikeDto createLike(Integer userId, Integer postId, Integer counter, boolean isLiked, boolean isLikeCountCreated);
	LikeDto updateLike(int likeCount, int likeId, int userId, int postId, boolean isLiked);
	void deleteLike(Integer likeId);
	LikeDto getLikeById(int likeId);
	
}
