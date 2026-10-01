package com.chandra.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chandra.dto.UserDTO;
import com.chandra.entity.User;
@Service
public interface UserService {
	
	public UserDTO createUser(UserDTO create);
	
	Optional<User> findUserByEmail(String email);
}
