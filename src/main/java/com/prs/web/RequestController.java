package com.prs.web;

import java.time.LocalDateTime;
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
	
		// Request Review
		@PutMapping("/submit-review")
		public Request submitForReview(@RequestBody Request r) {
			if (r.getTotal() <= 50.00) {
				r.setStatus("Approved");
			} else {
				r.setStatus("Review");
			}
			
			r.setSubmittedDate(LocalDateTime.now());
			r = requestRepo.save(r);
			return r;
		}
		
		// Request Approve
		@PutMapping("/approve")
		public Request approveRequest(@RequestBody Request r) {
			r.setStatus("Approved");
			r = requestRepo.save(r);
			return r;
		}
		
		// Request Approve
		@PutMapping("/reject")
		public Request rejectRequest(@RequestBody Request r) {
			r.setStatus("Rejected");
			r = requestRepo.save(r);
			return r;
		}
	

}
