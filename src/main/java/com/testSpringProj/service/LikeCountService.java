package com.testSpringProj.service;

import com.testSpringProj.payloads.LikeCountDto;

public interface LikeCountService {
	
	public LikeCountDto getLikeCount(int likeCountId);
	public LikeCountDto createLikeCount(LikeCountDto likeCountDto);
	public LikeCountDto updateLikeCount(LikeCountDto likeCountDto);

}
