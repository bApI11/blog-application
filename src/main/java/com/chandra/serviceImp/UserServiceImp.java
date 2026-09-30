package com.chandra.serviceImp;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandra.entity.User;
import com.chandra.entity.dto.UserDTO;
import com.chandra.repo.UserRepo;
import com.chandra.service.UserService;
@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDTO createUser(UserDTO create) {
		
		if(userRepo.findUserByEmail(create.getEmail()).isPresent()) {
			throw new RuntimeException("Email is already present");
		}
		User user= new User();
		user.setFname(create.getFirstName());
		user.setLname(create.getLastName());
		user.setEmail(create.getEmail());
		user.setPsw(create.getPassword());
		
		userRepo.save(user);
		
		return null;
	}

	@Override
	public Optional<User> findUserByEmail(String userEmail) {
		
		return userRepo.findUserByEmail(userEmail);
	}

}
