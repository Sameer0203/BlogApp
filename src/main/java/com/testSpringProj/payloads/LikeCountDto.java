package com.testSpringProj.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class LikeCountDto {
	
	private int postId;
	private int likeCount;

}
