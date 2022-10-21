package com.shopcart.shop;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
	
	private String productId;
	private String productName;
	private String brandName;
	private Integer price = 99;
	private Integer tax = 1;
	private boolean available;
	private Integer stock;
	private final LocalDate firstUpdateDate;
	private LocalDate lastUpdate;

	public Product(String productId, String productName, String brandName, Integer stock) {
		this.productId = productId;
		this.productName = productName;
		this.brandName = brandName;
		this.stock = stock;
		updateDate();
		this.firstUpdateDate = this.lastUpdate;
		if (stock > 0) available = true;
		else available = false;
	}
	
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getTax() {
		return tax;
	}

	public void setTax(Integer tax) {
		this.tax = tax;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	private void updateDate() {
		this.lastUpdate = LocalDate.now();
	}
	
	public String getFirstUpdateDate() {
		return this.firstUpdateDate.toString();
	}
	
	public String getLastUpdatedDate() {
		return this.lastUpdate.toString();
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	public void setBrandName(String name) {
		brandName = name;
	}
	
	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer count) {
		this.stock = count;
		if (stock <= 0) available = false;
	}
	
	public void addStock(Integer count) {
		if (null == count) count = 1;
		this.stock += count;
	}
	
	public void remStock(Integer count) {
		if (null == count) count = 0;
		this.stock = (count > this.stock)? 
				0 : this.stock - count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(productId, other.productId);
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", brandName=" + brandName
				+ ", price=" + price + ", tax=" + tax + "]";
	}

}
