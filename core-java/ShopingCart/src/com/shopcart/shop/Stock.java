package com.shopcart.shop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.shopcart.exceptions.InvalidProductException;

public class Stock {

	private static final String PRODUCT_STOCK = "db/products.bin";
	private Map<String, Product> productList;
	
	public Stock() {
		productList = new HashMap<>();
	}
	
	@SuppressWarnings("unchecked")
	public Stock(boolean flag) {
		File file = new File(PRODUCT_STOCK);
		if (!file.exists()) productList = new HashMap<>();
		else {
			try (FileInputStream fis = new FileInputStream(file);
					ObjectInputStream ois = new ObjectInputStream(fis)) {
					productList = (HashMap<String, Product>)ois.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void saveStock() {
		File file = new File(PRODUCT_STOCK);
		
		try (FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(productList);
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Product getProduct(String id) throws InvalidProductException {
		if (!productList.containsKey(id)) throw new InvalidProductException("No such product");
		return productList.get(id);
	} 
	
	public void addNewToStock(Product product) 
			throws InvalidProductException {
		if (contains(product.getProductId()))
			throw new InvalidProductException("Duplicate product");
		productList.put(product.getProductId(), product);
	}
	
	public void removeItemFromStock(String id) throws InvalidProductException {
		if (!contains(id)) throw new InvalidProductException("Invalid Id");
		productList.remove(id);
	}
	
	public boolean contains(String id) {
		return productList.containsKey(id);
	}
	
	public void updateStock(String productId, Integer stock) throws InvalidProductException {
		if (!productList.containsKey(productId)) throw new InvalidProductException("Invalid product id.");
		productList.get(productId).setStock(stock);
	}
	
	public void updatePriceAndTax(String id, int price, int tax) throws InvalidProductException {
		Product product = getProduct(id);
		product.setPrice(price);
		product.setTax(tax);
	}
	
	@Override
	protected void finalize() throws Throwable {
		saveStock();
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		List<Product> list = productList.values().stream()
				.filter((p) -> p.isAvailable())
				.collect(Collectors.toList());
		list.forEach((p) -> {
			str.append(p.toString());
			str.append("\n");
		});
		return str.toString();
	}
	
}
