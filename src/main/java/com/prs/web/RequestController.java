package com.prs.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prs.business.Request;
import com.prs.db.RequestRepo;

@CrossOrigin
@RestController
@RequestMapping("/requests")
public class RequestController {
	
	@Autowired
	public RequestRepo requestRepo; 
	
	// Get All
		@GetMapping("/")
		public List<Request> getAll() {
			return requestRepo.findAll();
		}
		
		// Get by ID
		@GetMapping("/{id}")
		public Optional<Request> getById(@PathVariable int id) {
			return requestRepo.findById(id);
		}
		
		// Add Request
		@PostMapping("/")
		public Request addRequest(@RequestBody Request r) {
			r = requestRepo.save(r);
			return r;
		}
		
		// Update a Request
		@PutMapping("/")
		public Request updateRequest(@RequestBody Request r) {
			r = requestRepo.save(r);
			return r;
		}
		
		// Delete a Product
		@DeleteMapping("/{id}")
		public Request deleteRequest(@PathVariable int id) {
			Optional<Request> r = requestRepo.findById(id);
			if (r.isPresent()) {
				requestRepo.deleteById(id);
			} else {
				System.out.println("Error - Product not found for id: " + id);
			}
			return r.get();
		}
	
	

}
