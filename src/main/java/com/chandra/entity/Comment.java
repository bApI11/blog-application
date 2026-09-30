package com.chandra.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="cmt_tbl")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	@Lob
	private String content;
	
	@CreationTimestamp
	private LocalDate creationOn;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
