package com.prs.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prs.business.Vendor;
import com.prs.db.VendorRepo;

@CrossOrigin
@RestController
@RequestMapping("/vendors")
public class VendorController {
	
	@Autowired
	public VendorRepo vendorRepo;
	
	// Get All
	@GetMapping("/")
	public List<Vendor> getAllVendors(Vendor v) {
		return vendorRepo.findAll();
	}
	
	// Get Vendor by ID
	@GetMapping("/{id}")
	public Optional<Vendor> getVendorById(@PathVariable int id) {
		return vendorRepo.findById(id);
	}
	
	// Add Vendor
	@PostMapping("/")
	public Vendor addVendor(@RequestBody Vendor v) {
		v = vendorRepo.save(v);
		return v;
	}
	
	// Update Vendor
	@PutMapping("/")
	public Vendor updateVendor(@RequestBody Vendor v) {
		v = vendorRepo.save(v);
		return v;
	}
	
	// Delete Vendor
	@DeleteMapping("/{id}")
	public Vendor deleteVendor(@PathVariable int id) {
		Optional<Vendor> v = vendorRepo.findById(id);
		if (v.isPresent()) {
			vendorRepo.deleteById(id);
		} else {
			System.out.println("Error - Vendor not found with ID: " + id);
		}
		return v.get();
	}

}
