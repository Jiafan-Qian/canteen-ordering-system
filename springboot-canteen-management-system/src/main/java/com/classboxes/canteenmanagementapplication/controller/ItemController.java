package com.classboxes.canteenmanagementapplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classboxes.canteenmanagementapplication.exception.ResourceNotFoundException;
import com.classboxes.canteenmanagementapplication.model.Customer;
import com.classboxes.canteenmanagementapplication.model.Item;
import com.classboxes.canteenmanagementapplication.repository.ItemRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/v1")
public class ItemController {
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/menu")
	public List<Item> getMenu()
	{
		return itemRepository.findAll();
	}
	
	
	@PostMapping("/menu")
	public Item createItem(@Valid @RequestBody Item item)
	{
		return itemRepository.save(item);
	}
	
	@GetMapping("/menu/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable(value = "id") Long itemId)
        throws ResourceNotFoundException {
        Item item = itemRepository.findById(itemId)
          .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + itemId));
        return ResponseEntity.ok().body(item);
    }
	
	@PutMapping("/menu/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable(value = "id") Long itemId,
         @Valid @RequestBody Item itemDetails) throws ResourceNotFoundException {
        Item item = itemRepository.findById(itemId)
        .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + itemId));

        item.setItemName(itemDetails.getItemName());
        item.setItemPrice(itemDetails.getItemPrice());
        
        final Item updatedItem = itemRepository.save(item);
        return ResponseEntity.ok(updatedItem);
    }
	
	@DeleteMapping("/menu/{id}")
    public Map<String, Boolean> deleteItem(@PathVariable(value = "id") Long itemId)
         throws ResourceNotFoundException {
        Item item = itemRepository.findById(itemId)
       .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + itemId));

        itemRepository.delete(item);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
