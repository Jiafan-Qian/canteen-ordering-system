package com.classboxes.canteenmanagementapplication.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetails extends AuditModel{
	
	@Id
	private Long itemId;
	
	@Column(name = "item_name", nullable = false)
	private String itemName;
	
	@Column(name = "unit_price", nullable = false)
	private double itemPrice;
	
	@Column(name = "quantity")
	private long quantity;
	
	@Column(name = "total_price")
	private double totalPrice;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order order;

	public OrderDetails() {
		super();
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderDetails(long id, String itemName, double itemPrice, long quantity, double totalPrice) {
		super();
		this.itemId = id;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderedItem [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", quantity="
				+ quantity + ", totalPrice=" + totalPrice + "]";
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	

}