package com.chandra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.chandra.dto.CommentDTO;
import com.chandra.dto.PostDTO;
import com.chandra.dto.UserDTO;
import com.chandra.entity.Comment;
import com.chandra.entity.Post;
import com.chandra.service.CommentService;
import com.chandra.service.PostService;


@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	@Autowired
	private PostService postService;
	
	@PostMapping("posts/{id}/comments")
	public String addComment(@PathVariable("id") Long postId,@ModelAttribute CommentDTO comment,Model model) {
	
		
		commentService.addComment(postId,comment);
		model.addAttribute("msg", "comment added ..");
		model.addAttribute("commentDTO", new CommentDTO());
		return "redirect:/comment/posts/" + postId;
	}
	
	@GetMapping("/comments")
	public String getComments(Model model) {
		List<Comment> commentList= commentService.getAllComment();
		model.addAttribute("comments", commentList);
		return "CommentPage";
	}
	
	
	@GetMapping("/posts/{id}")
	public String viewPost(@PathVariable Long id, Model model) {

	    PostDTO post = postService.getPostById(id);
	    List<Comment> commentList= commentService.getCommentsByPostId(id);
	    model.addAttribute("post", post);
	    model.addAttribute("comments", commentList);
	    model.addAttribute("commentDTO", new CommentDTO());
	    model.addAttribute("userDTO", new UserDTO());
	    return "PostDetails";
	}
	@DeleteMapping
	public String delete(@RequestParam Long commentId,Model model) {
		
		commentService.deleteComment(commentId);
		model.addAttribute("msg", "Comment delete successful...");
		
		return "Comments";
	}

}
