package com.chandra.service;

import org.springframework.data.domain.Page;

import com.chandra.dto.PostDTO;
import com.chandra.entity.Post;


public interface PostService {
	
	public void createPost(PostDTO create);
	
	public Page<Post> getAllPosts(int page,int pageSize);
	
	public PostDTO getPostById(Long id);
	
	public void delete(Long id);

}
