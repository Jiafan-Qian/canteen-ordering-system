package com.classboxes.canteenmanagementapplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classboxes.canteenmanagementapplication.exception.ResourceNotFoundException;
import com.classboxes.canteenmanagementapplication.model.Customer;
import com.classboxes.canteenmanagementapplication.model.Order;
import com.classboxes.canteenmanagementapplication.repository.OrderRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/v1")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	//save an order
	@PostMapping("/orders")
	public Order saveOrder(@Valid @RequestBody Order order)
	{
		return orderRepository.save(order);
	}
	
	//get all orders
	@GetMapping("/orders")
	public List<Order> getAllOrders()
	{
		return orderRepository.findAll();
	}
	
	//update orders
	@PutMapping("/orders/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") String orderId,
	         @Valid @RequestBody Order orderDetails) throws ResourceNotFoundException {
	        Order order = orderRepository.findById(orderId)
	        .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));

	        order.setAmount(orderDetails.getAmount());
	        order.setCustomerId(orderDetails.getCustomerId());
	        order.setStatus(orderDetails.getStatus());
	        order.setOrderDate(orderDetails.getOrderDate());
	        order.setComments(orderDetails.getComments());
	        
	        final Order updatedOrder = orderRepository.save(order);
	        return ResponseEntity.ok(updatedOrder);
	    }	
	

}
