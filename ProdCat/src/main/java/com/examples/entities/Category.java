package com.examples.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor 
public class Category implements Serializable {
	
	@Id	
	private String ref;
	private String name;
	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
	@JsonBackReference
	private Collection<Product> products;
	
	public Category(String name, Collection<Product> products) {
		super();		
		this.name = name;
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [ref=" + ref + ", name=" + name + "]";
	}
	
	

}
