package com.tecma.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tecma.entities.Photo;


@Entity

@Table(name = "product")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column(name = "companyName")
	private String companyName;

	@Column(name = "description")
	private String description;

	@Column(name = "expiryDate")
	private Date expiryDate;

	@Column(name = "loss")
	private Double loss;

	@Column(name = "lossPercent")
	private String lossPercent;

	@Column(name = "manufactureDate")
	private Date manufactureDate;

	@Column(name = "name")
	private String name;

	@Column(name = "profit")
	private Double profit;

	@Column(name = "profitPercent")
	private String profitPercent;

	@Column(name = "quantityOfMeasure")
	private String quantityOfMeasure;

	@Column(name = "costPrice")
	private Double costPrice;

	@Column(name = "sellingPrice")
	private Double sellingPrice;

	@Column(name = "stock")
	private int stock;
	
	@OneToMany(targetEntity=Photo.class,
			mappedBy="productId",
			fetch=FetchType.EAGER,
			cascade=CascadeType.ALL)
	private List<Photo> photos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Double getLoss() {
		return loss;
	}

	public void setLoss(Double loss) {
		this.loss = loss;
	}

	public String getLossPercent() {
		return lossPercent;
	}

	public void setLossPercent(String lossPercent) {
		this.lossPercent = lossPercent;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getProfit() {
		return profit;
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}

	public String getProfitPercent() {
		return profitPercent;
	}

	public void setProfitPercent(String profitPercent) {
		this.profitPercent = profitPercent;
	}

	public String getQuantityOfMeasure() {
		return quantityOfMeasure;
	}

	public void setQuantityOfMeasure(String quantityOfMeasure) {
		this.quantityOfMeasure = quantityOfMeasure;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

}