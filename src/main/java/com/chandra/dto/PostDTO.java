package com.chandra.dto;


import jakarta.persistence.Lob;
import lombok.Data;
@Data
public class PostDTO {
	
	private Long postId;
	private String title;
	private String shortDescription;
	@Lob
	private String content;

}
