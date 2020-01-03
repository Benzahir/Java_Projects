package com.examples.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.examples.dao.CategoryRepository;
import com.examples.dao.ProductRepository;
import com.examples.entities.Category;
import com.examples.entities.Product;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/index")
	public String getListProducts(Model model) {
		
		model.addAttribute("product", new Product());

		List<Product> list = productRepository.findAll();
		model.addAttribute("products", list);
		
		List<Category> list1 = categoryRepository.findAll();
		model.addAttribute("categories",list1);

		return "produits";
	}
	
	@PostMapping(value = "/SaveProduct")
	public String saveProduct(@Valid Product product, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "produits";
		}
		productRepository.save(product);
		return "redirect:index";
	}
	
	@GetMapping("/edit")
	public String edit(Model model, Long id) {
		Product product = productRepository.findById(id).get();
		model.addAttribute("product",product);
		return "redirect:index";
	}
	
	@RequestMapping("/deleteProduct")
	public String deleteTaxe(Long id) {
		productRepository.deleteById(id);
		return "redirect:index";
	}

	@RequestMapping("/allProducts")
	@ResponseBody
	public List<Product> getProduits() {
		return productRepository.findAll();
	}
	
	@GetMapping("/product/{id}")
    ResponseEntity<?> getGroup(@PathVariable Long id) {
        Optional<Product> group = productRepository.findById(id);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
	@GetMapping("/allCategories")
	public String getCategories(Model model) {
		List<Category> list = categoryRepository.findAll();
		model.addAttribute("categories",list);
		return "categories";
	}
	
	@RequestMapping("/allP")
	@ResponseBody
	public List<Product> getProduitsparC(Category c) {
		return productRepository.findByCategory(c);
	}
	
	@RequestMapping(value="/index2")
	public String index() {
		return "index";
	}

}
