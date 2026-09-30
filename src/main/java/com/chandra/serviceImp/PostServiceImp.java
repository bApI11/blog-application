package com.chandra.serviceImp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.chandra.entity.Post;
import com.chandra.entity.dto.PostDTO;
import com.chandra.repo.PostRepo;
import com.chandra.service.PostService;

@Service
public class PostServiceImp implements PostService{
	
	@Autowired
	private PostRepo postRepo;

	@Override
	public void createPost(PostDTO create) {
		
		Post post= new Post();
		post.setTitle(create.getTitle());
		post.setDescrip(create.getShortDescription());
		post.setContent(create.getContent());
		post.setCreateOn(LocalDate.now());
		System.out.println("save data");
		System.out.println(post);
		
		postRepo.save(post);
		
	}

	@Override
	public Page<Post> getAllPosts(int page,int pageSize) {
		
		Page<Post> postList = postRepo.findAll(
				PageRequest.of(page, pageSize,Sort.by("id").ascending()));
		return postList;
	}

	@Override
	public PostDTO getPostById(Long id) {
		
		Post post= postRepo.getById(id);
		PostDTO dto= new PostDTO();
		dto.setTitle(post.getTitle());
		dto.setShortDescription(post.getDescrip());
		dto.setContent(post.getContent());
		return dto;
	}

	@Override
	public void delete(Long id) {
		
		postRepo.deleteById(id);
		
	}

}
