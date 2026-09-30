package com.chandra.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandra.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	Optional<User> findUserByEmail(String userEmail);

}
