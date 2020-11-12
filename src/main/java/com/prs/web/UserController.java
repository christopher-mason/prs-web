package com.prs.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.prs.business.User;
import com.prs.db.UserRepo;

@CrossOrigin
@RestController
@RequestMapping("/users")
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
	
	// Get user username and password
	@GetMapping("/login")
	public Optional<User> login(@RequestParam String userName, @RequestParam String password) {
		Optional<User> u = userRepo.findByUserNameAndPassword(userName, password);
		if (u.isPresent()) {
			return u;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}
	}
	
	@PostMapping("/login")
	public Optional<User> login(@RequestBody User u) {
		Optional<User> user = userRepo.findByUserNameAndPassword(u.getUserName(), u.getPassword());
		if (user.isPresent()) {
			return user;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}
	}
	
}
