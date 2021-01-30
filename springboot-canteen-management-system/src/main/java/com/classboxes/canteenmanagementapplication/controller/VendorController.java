package com.classboxes.canteenmanagementapplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classboxes.canteenmanagementapplication.exception.ResourceNotFoundException;
import com.classboxes.canteenmanagementapplication.model.Customer;
import com.classboxes.canteenmanagementapplication.model.Vendor;
import com.classboxes.canteenmanagementapplication.repository.VendorRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/v1")
public class VendorController {
	
	@Autowired
	VendorRepository vendorRepository;
	
	@PostMapping("/vendors")
	public Vendor createVendor(@Valid @RequestBody Vendor vendor)
	{
		return vendorRepository.save(vendor);
	}
	
	@GetMapping("/vendors")
	public List<Vendor> getAllVendors()
	{
		return vendorRepository.findAll();
	}

	@GetMapping("/vendors/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable(value = "id") Long vendorId)
        throws ResourceNotFoundException {
        Vendor vendor = vendorRepository.findById(vendorId)
          .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + vendorId));
        return ResponseEntity.ok().body(vendor);
	}
}
