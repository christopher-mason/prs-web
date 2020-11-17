package com.prs.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prs.business.LineItem;
import com.prs.db.LineItemRepo;

@CrossOrigin
@RestController
@RequestMapping("/lineitems")
public class LineItemController {

	@Autowired
	private LineItemRepo lineItemRepo;
	
	// Get all Line Items
	@GetMapping("/")
	public List<LineItem> getAllUsers(LineItem li) {
		return lineItemRepo.findAll();
	}
	
	// Get Line Items by ID
	@GetMapping("/{id}")
	public Optional<LineItem> getLineItemById(@PathVariable int id) {
		return lineItemRepo.findById(id);
	}
	
	// Add User
	@PostMapping("/")
	public LineItem addLineItem(@RequestBody LineItem li) {
		li = lineItemRepo.save(li);
			return li;
	}
	
	// Update User
	@PutMapping("/")
	public LineItem updateLineItem(@RequestBody LineItem li) {
		li = lineItemRepo.save(li);
			return li;
	}
	
	// Delete User
	@DeleteMapping("/{id}")
	public LineItem deleteLineItem(@PathVariable int id) {
		Optional<LineItem> li = lineItemRepo.findById(id);
			if (li.isPresent()) {
				lineItemRepo.deleteById(id);
			} else {
				System.out.println("Error - Line Item not found with ID: " + id);
			}
			return li.get();
	}
	
	// list line items for a purchase request
	@GetMapping("/lines-for-pr/{id}")
	public List<LineItem> getLineItemByPr(@PathVariable int id){
		return lineItemRepo.findByRequestId(id); 
		
	}
	
	
}
