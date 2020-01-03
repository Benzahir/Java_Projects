package com.tecma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tecma.entities.Product;
import com.tecma.repositories.ProductRepository;

@Controller
public class PublicProductController {
	
	private ProductRepository productRepository;
	
	@Autowired
	public PublicProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@RequestMapping("/products")
	public String index(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		return "index";
	}

}
