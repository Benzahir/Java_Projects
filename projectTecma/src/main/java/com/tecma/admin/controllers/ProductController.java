package com.tecma.admin.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tecma.entities.Product;
import com.tecma.repositories.ProductRepository;
import com.tecma.services.ProductService;

@Controller
public class ProductController {
	
	private ProductRepository productRepository;
	private ProductService productService;
	
	public ProductController(ProductRepository productRepository, ProductService productService) {
		this.productRepository = productRepository;
		this.productService = productService;
	}
	
	@RequestMapping("/admin/product/list")
	public String list(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		return "admin/product/list";
	}
	
	@RequestMapping(value="/admin/product/create", method=RequestMethod.GET)
	public String create(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "admin/product/create";
	}
	
	@RequestMapping(value="/admin/product/create", method=RequestMethod.POST)
	public String create(@ModelAttribute("product") Product product,
			BindingResult result, RedirectAttributes redirectAttributes, @RequestParam("files") MultipartFile[] files) {
		if (result.hasErrors()) {
			System.out.println("error " + result.getAllErrors().toString());
			return null;
		}
		
		productService.save(product, files);
		return "redirect:/admin/product/list";
	}
	
	@RequestMapping(value="/admin/product/{id}/edit", method=RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, Model model) {
		Product product = productRepository.findOne(id);
		model.addAttribute("product", product);
		return "admin/product/create";
	}
	
	@RequestMapping(value="/admin/product/{id}/edit", method=RequestMethod.POST)
	public String edit( @ModelAttribute("product") @Valid Product product, 
			BindingResult result, RedirectAttributes redirectAttributes, @RequestParam("files") MultipartFile[] files) {
		if (result.hasErrors()) {
			System.out.println("error " + result.getAllErrors().toString());
			return null;
		}
		
		productService.update(product.getId(), product, files);
		return "redirect:/admin/product/list";
	}
	
	@RequestMapping("/admin/product/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		productRepository.delete(id);
		return "redirect:/admin/product/list";
	}
	
	@RequestMapping("/admin/product/{id}/show")
	public String show(@PathVariable("id") Long id, Model model) {
		Product product = productRepository.findOne(id);
		model.addAttribute("product", product);
		return "/admin/product/show";
	}

}
