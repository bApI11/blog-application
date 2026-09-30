package com.chandra.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chandra.entity.Comment;

@Service
public interface CommentService {
	
	public Comment addComment(Comment comment);
	
	List<Comment> getComments();
	
	public void deleteComment(Long commentId);
	
	public void updateComment(Comment comment);
	
}
