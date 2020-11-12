package com.prs.web;

import java.util.List;

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
	
	// Get all Users
		@GetMapping("/")
		public List<LineItem> getAllUsers(LineItem li) {
			return lineItemRepo.findAll();
		}
}
