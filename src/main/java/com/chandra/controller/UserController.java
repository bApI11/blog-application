package com.chandra.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chandra.dto.UserDTO;
import com.chandra.entity.Post;
import com.chandra.entity.User;
import com.chandra.service.PostService;
import com.chandra.service.UserService;

@org.springframework.stereotype.Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	
	@GetMapping
	public String logIn(Model model) {
		postList(model);
		//model.addAttribute("user", new User());
		return "Index";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute UserDTO dto,Model model) {
		try {
			userService.createUser(dto);
			model.addAttribute("msg", "Registration successfull....");
			return "Login";
			
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			model.addAttribute("userDto", new UserDTO());
			return "Register";
		}
	}
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("userDTO", new UserDTO());
		return "Register";
	}
	
	@PostMapping("/loginPage")
	public String logIn(@RequestParam String userEmail, @RequestParam String userPsw,Model model) {
		
		Optional<User> optionalUser= userService.findUserByEmail(userEmail);
		if(optionalUser.isPresent()) {
			User user= optionalUser.get();
		if(user.getPsw().equals(userPsw)) {
			postList(model);
			return "DashBoard";
			}
		else {
			 model.addAttribute("msg", "invalid user");
		}
		}else {
			model.addAttribute("msg", "invalid user");
		}
		return "Login";
		
	}
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		
		model.addAttribute("userDTO", new UserDTO());
		return "Login";
	}
	
	private void postList(Model model) {
		int page=0,pageSize=5;
		Page<Post> postList= postService.getAllPosts(page, pageSize);
		model.addAttribute("posts", postList);
	}

}
