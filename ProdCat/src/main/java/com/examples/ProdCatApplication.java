package com.examples;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.examples.dao.CategoryRepository;
import com.examples.dao.ProductRepository;
import com.examples.entities.Category;
import com.examples.entities.Product;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@SpringBootApplication
public class ProdCatApplication {
	
	@Autowired
	private RepositoryRestConfiguration restConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(ProdCatApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(CategoryRepository categoryRepository,ProductRepository productRepository) {
		restConfiguration.exposeIdsFor(Product.class);
		return s -> {
			
			categoryRepository.deleteAll();
			Stream.of("C1 Laptops","C2 Cameras").forEach(c->{
				categoryRepository.save(new Category(c.split(" ")[0],c.split(" ")[1],new ArrayList<>()));
			});
			categoryRepository.findAll().forEach(System.out::println);
			
			productRepository.deleteAll();
			Category c1 = categoryRepository.findById("C1").get();
			Stream.of("P1","P2","P3","P4").forEach(p->{
				productRepository.save(new Product(p,200,c1));
			});
			
			
			Category c2 = categoryRepository.findById("C2").get();
			Stream.of("P5","P6").forEach(p->{
				productRepository.save(new Product(p,200,c2));
			});
			
			productRepository.findAll().forEach(p->{
				System.out.println(p.toString());
			});
			
		};
		
	}


}
