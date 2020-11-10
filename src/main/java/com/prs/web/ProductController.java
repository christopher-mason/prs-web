package com.prs.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prs.business.Product;
import com.prs.db.ProductRepo;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {
	/*
	 *  A controller will implement 5 CRUD methods:
	 *  1) GET ALL
	 *  2) GET BY ID
	 *  3) POST - Insert/Create
	 *  4) PUT - Update
	 *  5) DELETE - Delete
	 */
	
	@Autowired
	private ProductRepo productRepo;
	
	// Get All
	@GetMapping("/")
	public List<Product> getAll() {
		return productRepo.findAll();
	}
	
	// Get by ID
	@GetMapping("/{id}")
	public Optional<Product> getById(@PathVariable int id) {
		return productRepo.findById(id);
	}
	
	// Add Product
	@PostMapping("/")
	public Product addProduct(@RequestBody Product p) {
		p = productRepo.save(p);
		return p;
	}
	
	// Update a Product
	@PutMapping("/")
	public Product updateProduct(@RequestBody Product p) {
		p = productRepo.save(p);
		return p;
	}
	
	// Delete a Product
	@DeleteMapping("/{id}")
	public Product deleteProduct(@PathVariable int id) {
		Optional<Product> p = productRepo.findById(id);
		if (p.isPresent()) {
			productRepo.deleteById(id);
		} else {
			System.out.println("Error - Product not found for id: " + id);
		}
		return p.get();
	}
	
}
