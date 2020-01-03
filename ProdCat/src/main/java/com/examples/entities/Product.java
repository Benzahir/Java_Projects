package com.examples.entities;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Product implements Serializable {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	@NotNull
	@Size(min=2,max=20)
	private String name;
	@DecimalMin("100")
	private double price;
	@ManyToOne	
	@JoinColumn(name="ID_CAT")
	private Category category;
	
	public Product(String name, double price,Category category) {
		super();
		this.name = name;
		this.price = price;
		this.category=category;
	}

	@Override
	public String toString() {
		 return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", price='" + price + '\'' +
				", category='" + category + '\'' +
				'}';
	}
	
	
	
	
	
}
