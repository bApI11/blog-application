package com.chandra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chandra.entity.Post;
import com.chandra.entity.dto.PostDTO;
import com.chandra.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	public String postPage(Model model) {
		model.addAttribute("postDto", new PostDTO());
		return "PostPage";
	}
	
	@PostMapping("/create")
	public String createPost(@ModelAttribute PostDTO postDto, Model model) {
		
		postService.createPost(postDto);
		model.addAttribute("msg", "post create successfull....");
		model.addAttribute("postDto", new PostDTO());
		postList(model);
		return "Dashboard";
	}
	
	@GetMapping("/posts")
	public String post(@RequestParam(defaultValue = "0") int page, Model model) {
		int pageSize= 5;
		Page<Post> pagePost=postService.getAllPosts(page, pageSize);
		model.addAttribute("posts", pagePost);
		model.addAttribute("postDto", new PostDTO());
		return "Dashboard";
	}
	
	@GetMapping("/edit/{id}")
	public String updatePost(@PathVariable Long id, Model model) {
		PostDTO post= postService.getPostById(id);
		model.addAttribute("postDto",post);
		model.addAttribute("msg", "post update success...");
		return "PostPage";
	}
	
	@GetMapping("delete/{id}")
	public String deletePost(@PathVariable Long id,Model model) {
		 
		postService.delete(id);
		model.addAttribute("msg", "post delete success");
		postList(model);
		model.addAttribute("postDto", new PostDTO());
		return "Dashboard";

	}
	private void postList(Model model) {
		int page=0,pageSize=5;
		Page<Post> postList= postService.getAllPosts(page, pageSize);
		model.addAttribute("posts", postList);
	}

}
