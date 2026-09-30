package com.chandra.entity.dto;


import jakarta.persistence.Lob;
import lombok.Data;
@Data
public class PostDTO {
	
	private String title;
	private String shortDescription;
	@Lob
	private String content;

}
