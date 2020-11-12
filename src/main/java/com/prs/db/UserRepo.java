package com.prs.db;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prs.business.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	// get users by username and password
	Optional<User> findByUserNameAndPassword(String userName, String password);

}
