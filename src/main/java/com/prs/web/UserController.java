package com.prs.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prs.business.User;
import com.prs.db.UserRepo;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepo userRepo;
	
	// Get all Users
	@GetMapping("/")
	public List<User> getAllUsers(User u) {
		return userRepo.findAll();
	}
	
	// Get User by ID
	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable int id) {
		return userRepo.findById(id);
	}
	
	// Add User
	@PostMapping("/")
	public User addUser(@RequestBody User u) {
		u = userRepo.save(u);
		return u;
	}
	
	// Update User
	@PutMapping("/")
	public User updateUser(@RequestBody User u) {
		u = userRepo.save(u);
		return u;
	}
	
	// Delete User
	@DeleteMapping("/{id}")
	public User deleteUser(@PathVariable int id) {
		Optional<User> u = userRepo.findById(id);
		if (u.isPresent()) {
			userRepo.deleteById(id);
		} else {
			System.out.println("Error - User not found with ID: " + id);
		}
		return u.get();
	}
	
}
