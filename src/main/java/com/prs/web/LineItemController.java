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
}