package com.just.at.nn;

import java.util.List;

public class Cart {

	private List<Product> cart;
	private Double currentBill;
	private Double totalDiscounts;
	private Double totalTaxes;
	
	public Cart() {
		this.cart = ProductUtils.initiateProductList(0);
		this.currentBill = 0.0;
		this.totalDiscounts = 0.0;
		this.totalTaxes = 0.0;
	}
	
	public String add(Integer id, Integer required) {
		if (!(id < 0 || id > cart.size())) {
			Product product = cart.get(id);
			this.currentBill += product.getProductPrice() * required;
			this.totalDiscounts += product.getProductDiscount() * required;
			this.totalTaxes += product.getProductTax() * required;
			product.setProductStock(required + product.getProductStock());
			return "Added Sucessfully";
		}
		return "Couldn't Add!";
	}
	
	public String remove(Integer id, Integer count) {
		if (!(id < 0 || id > cart.size())) {
			Product product = cart.get(id);
			
			if (product.getProductStock() < count) count = product.getProductStock();
			else count = product.getProductStock() - count;
			
			this.currentBill -= product.getProductPrice() * count;
			this.totalDiscounts -= product.getProductDiscount() * count;
			this.totalTaxes -= product.getProductTax() * count;
			product.setProductStock(count);
			if (count <= 0) {
				product.setAvailability(false);
			}
			return "Removed";
		}
		return "Not such item";
	}

	public Double getCurrentBill() {
		return currentBill;
	}

	public Double getTotalDiscounts() {
		return totalDiscounts;
	}

	public Double getTotalTaxes() {
		return totalTaxes;
	}
	
	public Double getPayableAmmount() {
		return (currentBill + totalTaxes - totalDiscounts); 
	}
	
	private String toStringEachIfAvailable() {
		StringBuilder result = new StringBuilder();
		
		for (Product p : cart) {
			if (p.isAvailable()) {
				result.append(p.toString());
				result.append("\n");
			}
		}
		
		return result.toString();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Added Items:\n");
		result.append(toStringEachIfAvailable());
		result.append("\nBill: " + currentBill.toString() + " Discount: " + totalDiscounts.toString() + 
				" Tax: " +totalTaxes.toString() + " Pay: " + getPayableAmmount().toString() + "\n");
		return result.toString();
	}
	
}
