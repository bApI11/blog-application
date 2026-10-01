package com.chandra.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chandra.dto.CommentDTO;
import com.chandra.entity.Comment;

@Service
public interface CommentService {
	
	public void addComment(Long postId,CommentDTO comment);
	
	List<Comment> getCommentsByPostId(Long postId);
	
	public void deleteComment(Long commentId);
	
	public void updateComment(Comment comment);
	
	List<Comment> getAllComment();
	
}
