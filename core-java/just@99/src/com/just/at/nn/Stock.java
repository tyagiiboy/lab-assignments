package com.just.at.nn;

import java.util.List;

public class Stock {
	private List<Product> stock;
	
	public Stock(Integer size) {
		stock = ProductUtils.initiateProductList(size);
	}
	
	public Integer add(Integer id, Integer count) {
		if (!(id < 0 || id > stock.size())) {
			Product product = stock.get(id);
			product.setProductStock(count + product.getProductStock());
			product.setAvailability(true);
			return product.getProductStock();
		}
		return -1;
	}
	
	public Integer remove(Integer id, Integer required) {
		if (!(id < 0 || id > stock.size())) {
			Product product = stock.get(id);
			if (!product.isAvailable()) return -1;
			Integer size = product.getProductStock();
			if (size < required) {
				required = size;
				size = 0;
			}
			else {
				size = size - required;
			}
			product.setProductStock(size);
			if (size == 0) product.setAvailability(false);
			return required;
		}
		return -1;
	}
	
	public Integer removeAll(Integer id) {
		if (!(id < 0 || id > stock.size())) {
			Product product = stock.get(id);
			Integer size = product.getProductStock();
			remove(id, size);
			return product.getProductStock();
		}
		return -1;
	}
	
	public String toStringEachIfAvailable() {
		StringBuilder result = new StringBuilder();
		
		for (Product p : stock) {
			if (p.isAvailable()) {
				result.append(p.toString());
				result.append("\n");
			}
		}
		
		return result.toString();
	}
	
	@Override
	public String toString() {
		return ""; 
	}
}
