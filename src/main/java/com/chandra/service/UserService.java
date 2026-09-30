package com.chandra.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chandra.entity.User;
import com.chandra.entity.dto.UserDTO;
@Service
public interface UserService {
	
	public UserDTO createUser(UserDTO create);
	
	Optional<User> findUserByEmail(String email);
}
