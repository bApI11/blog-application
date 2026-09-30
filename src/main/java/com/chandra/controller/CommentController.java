package com.chandra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chandra.entity.Comment;
import com.chandra.service.CommentService;


@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping
	public String addComment(@ModelAttribute Comment comment,Model model) {
		
		commentService.addComment(comment);
		model.addAttribute("msg", "comment added ..");
		return "Index";
	}
	
	@GetMapping("/comments")
	public String getComments(Model model) {
		List<Comment> commentList= commentService.getComments();
		model.addAttribute("comments", commentList);
		return "CommentPage";
	}
	
	@PutMapping("edit/{id}")
	public String editComment(@ModelAttribute Comment comment,Model model) {
		
		commentService.updateComment(comment);
		model.addAttribute("msg", "Comment update successful...");
		return "Comments";
	}
	
	public String delete(@RequestParam Long commentId,Model model) {
		
		commentService.deleteComment(commentId);
		model.addAttribute("msg", "Comment delete successful...");
		
		return "Comments";
	}

}
