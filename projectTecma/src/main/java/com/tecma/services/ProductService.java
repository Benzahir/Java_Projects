package com.tecma.services;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.tecma.entities.Photo;
import com.tecma.entities.Product;
import com.tecma.repositories.PhotoRepository;
import com.tecma.repositories.ProductRepository;
import com.tecma.util.ImageProcessingService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductService {

	private ProductRepository productRepository;
	private PhotoRepository photoRepository;
	private ImageProcessingService imageProcessingService;

	@Autowired
	public ProductService(ProductRepository productRepository, PhotoRepository photoRepository,
			ImageProcessingService imageProcessingService) {
		this.productRepository = productRepository;
		this.photoRepository = photoRepository;
		this.imageProcessingService = imageProcessingService;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Product save(Product product, MultipartFile[] file) {
		String photoPath;
		String f = new File("src/main/resources/static/photos/product").getAbsolutePath();

		Product p = new Product();
		try {
			p.setName(product.getName());
			p.setCompanyName(product.getCompanyName());
			p.setDescription(product.getDescription());
			p.setCostPrice(product.getCostPrice());
			p.setSellingPrice(product.getSellingPrice());
			if (product.getSellingPrice() > product.getCostPrice()) {
				Double profit = (Double) (product.getSellingPrice() - product.getCostPrice());
				p.setProfit(profit);
				double per = (profit / product.getCostPrice()) * 100;
				String percent = per + "%";
				p.setProfitPercent(percent);
			}
			if (product.getCostPrice() > product.getSellingPrice()) {
				Double loss = product.getCostPrice() - product.getSellingPrice();
				p.setLoss(loss);
				double l = (loss / product.getCostPrice()) * 100;
				String lpercent = l + "%";
				p.setLossPercent(lpercent);
			}
			p.setManufactureDate(product.getManufactureDate());
			p.setExpiryDate(product.getExpiryDate());
			p.setQuantityOfMeasure(product.getQuantityOfMeasure());
			p.setStock(product.getStock());
			product = productRepository.save(p);
			if (file.length > 0) {
				if (f.contains("src/main/resources/static/photos/product")) {
					photoPath = "/" + product.getId();
				} else {
					photoPath = "/product/" + product.getId();
				}
				List<String> photoname = imageProcessingService.handleFileUpload(file, photoPath);
				for (int x = 0; x < photoname.size(); x++) {
					Photo photo = new Photo();
					photo.setCaption(product.getName());
					photo.setProductId(product.getId());
					photo.setPhotoPath(photoname.get(x));
					photoRepository.save(photo);
				}
			}
		} catch (

		Exception e) {
			e.printStackTrace();
			return null;
		}
		return product;

	}

	public Product update(Long id, Product product, MultipartFile[] file) {
		String photoPath;
		String f = new File("src/main/resources/static/photos/product").getAbsolutePath();

		Product p = productRepository.findOne(id);
		try {
			p.setName(product.getName());
			p.setCompanyName(product.getCompanyName());
			p.setDescription(product.getDescription());
			p.setCostPrice(product.getCostPrice());
			p.setSellingPrice(product.getSellingPrice());

			if (product.getSellingPrice() > product.getCostPrice()) {
				Double profit = (Double) (product.getSellingPrice() - product.getCostPrice());
				p.setProfit(profit);
				double per = (profit / product.getCostPrice()) * 100;
				String percent = per + "%";
				p.setProfitPercent(percent);
			}

			if (product.getCostPrice() > product.getSellingPrice()) {
				Double loss = product.getCostPrice() - product.getSellingPrice();
				p.setLoss(loss);
				double l = (loss / product.getCostPrice()) * 100;
				String lpercent = l + "%";
				p.setLossPercent(lpercent);
			}

			p.setManufactureDate(product.getManufactureDate());
			p.setExpiryDate(product.getExpiryDate());
			p.setQuantityOfMeasure(product.getQuantityOfMeasure());
			p.setStock(product.getStock());
			productRepository.save(p);
			if (file.length > 0) {
				if (f.contains("src/main/resources/static/photos/product")) {
					photoPath = "/" + product.getId();
				} else {
					photoPath = "/product/" + product.getId();
				}
				List<String> photoname = imageProcessingService.handleFileUpload(file, photoPath);
				for (int x = 0; x < photoname.size(); x++) {
					Photo photo = new Photo();
					photo.setCaption(product.getName());
					photo.setProductId(product.getId());
					photo.setPhotoPath(photoname.get(x));
					photoRepository.save(photo);
				}
			}
		} catch (Exception e)

		{
			e.printStackTrace();
			return null;
		}
		return p;
	}

}
