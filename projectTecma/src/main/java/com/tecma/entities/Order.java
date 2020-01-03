package com.tecma.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "orders", indexes = { @Index(columnList = "product__id, product_name, order_number") })
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	// fields/properties

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, name = "product__id")
	private long productId;

	@Column(nullable = false, name = "product_name", length = 60)
	private String productName;

	@Column(nullable = false)
	private String quantityOfMeasure;

	@Column(nullable = false, columnDefinition = "decimal(10,4) default 0.000")
	private Double unitPrice;

	@Column(nullable = false, columnDefinition = "decimal(10,4) default 0.000")
	private Double totalPrice;
	
	@Column(nullable = false, name = "order_number")
	private long orderNumber;
	
	public String getQuantityOfMeasure() {
		return quantityOfMeasure;
	}

	public void setQuantityOfMeasure(String quantityOfMeasure) {
		this.quantityOfMeasure = quantityOfMeasure;
	}

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
