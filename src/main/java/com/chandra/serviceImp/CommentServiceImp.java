package com.chandra.serviceImp;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandra.dto.CommentDTO;
import com.chandra.entity.Comment;
import com.chandra.entity.Post;
import com.chandra.repo.CommentRepo;
import com.chandra.repo.PostRepo;
import com.chandra.service.CommentService;
@Service
public class CommentServiceImp implements CommentService{
	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private PostRepo postRepo;
	@Override
	public void addComment(Long postId,CommentDTO comment) {
		
		Post post=postRepo.findById(postId).orElseThrow(() ->
							new RuntimeException("post not found"));
		
		Comment newComment =new Comment();
		newComment.setName(comment.getName());
		newComment.setEmail(comment.getEmail());
		newComment.setCreationOn(LocalDate.now());
		newComment.setContent(comment.getContent());
		newComment.setPost(post);
		
		commentRepo.save(newComment);
		
	}
	@Override
	public List<Comment> getCommentsByPostId(Long postId) {
		// TODO Auto-generated method stub
		return commentRepo.findByPostId(postId);
	}
	@Override
	public void deleteComment(Long commentId) {
		
		commentRepo.deleteById(commentId);
		
	}
	@Override
	public void updateComment(Comment comment) {
		
		Optional<Comment> optionalComment= commentRepo.findById(comment.getId());
		if(optionalComment.isPresent()) {
			Comment newComment= new Comment();
			BeanUtils.copyProperties(optionalComment,newComment);
		}
	}
	@Override
	public List<Comment> getAllComment() {
		// TODO Auto-generated method stub
		return commentRepo.findAll();
	}

}
