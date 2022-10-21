package com.just.at.nn;

import java.time.LocalDate;

public class Product implements Comparable<Product> {

	private Integer productId;
	private String productName;
	private Integer productStock;
	private LocalDate productAdditionDate;
	private Double productPrice;
	private Double productTax;
	private Double productDiscount;
	private boolean availability = false;
	
	public Product() {
		this.productId = -1;
		this.productName = Utils.EMPTY_STRING;
		this.productStock = 0;
		this.productAdditionDate = null;
		this.productPrice = 0.0;
		this.productTax = 0.0;
		this.productDiscount = 0.0;
	}

	public Product(Integer productId, String productName, Integer productStock,
			LocalDate productAdditionDate, Double price, Double tax, Double discount) {
		if (productStock > 0) this.availability = true;
		this.productId = productId;
		this.productName = productName;
		this.productStock = productStock;
		this.productAdditionDate = productAdditionDate;
		this.productPrice = price;
		this.productTax = tax;
		this.productDiscount = discount;
	}

	public Integer getProductId() {
		return productId;
	}
	
	public String getProductName() {
		return productName;
	}

	public Integer getProductStock() {
		return productStock;
	}

	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}

	public LocalDate getProductAdditionDate() {
		return productAdditionDate;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public Double getProductTax() {
		return productTax;
	}

	public void setProductTax(Double productTax) {
		this.productTax = productTax;
	}

	public Double getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(Double productDiscount) {
		this.productDiscount = productDiscount;
	}
	
	public boolean isAvailable() {
		return this.availability;
	}
	
	public void setAvailability(boolean flag) {
		this.availability = flag;
	}

	@Override
	public int compareTo(Product o) {
		return this.productId.compareTo(o.productId);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (o.getClass() != this.getClass()) return false;
		
		Product product = (Product)o;
		if (this.productId != product.productId || !this.productName.equals(productName)) return false;
		return true;
	}

	@Override
	public String toString() {
		return (productId + 1) + " " + productName + " " + 
				productPrice.toString() + " " + productDiscount.toString();
	}

	public String toStringAll() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productStock=" + productStock
				+ ", productAdditionDate=" + productAdditionDate + ", productPrice=" + productPrice + ", productTax="
				+ productTax + ", productDiscount=" + productDiscount + ", availability=" + availability + "]";
	}

}
