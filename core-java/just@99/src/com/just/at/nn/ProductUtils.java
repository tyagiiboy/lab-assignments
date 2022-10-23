package com.just.at.nn;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductUtils {

	public static List<Product> initiateProductList(int stockCount) {
		Products[] products = Products.values();
		List<Product> list = new ArrayList<>();
		
		for (Products e : products) {
			Integer productId = e.ordinal();
			String productName = e.name();
			Integer productStock = stockCount;
			LocalDate productAdditionDate = LocalDate.now();
			Double productPrice = 99.99;
			Double productTax = 5.0;
			Double productDiscount = 5.0;
			
			Product p = new Product(productId, productName, productStock,
					productAdditionDate, productPrice, productTax, productDiscount);
			list.add(p);
		}
		
		return list;
	}
	
}
