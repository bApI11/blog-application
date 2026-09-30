package com.chandra.serviceImp;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandra.entity.Comment;
import com.chandra.repo.CommentRepo;
import com.chandra.service.CommentService;
@Service
public class CommentServiceImp implements CommentService{
	@Autowired
	private CommentRepo commentRepo;
	@Override
	public Comment addComment(Comment comment) {
		
		Comment newComment =new Comment();
		newComment.setName(comment.getName());
		newComment.setCreationOn(LocalDate.now());
		newComment.setContent(comment.getContent());
		
		commentRepo.save(comment);
		return comment;
	}
	@Override
	public List<Comment> getComments() {
		// TODO Auto-generated method stub
		return commentRepo.findAll();
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

}
