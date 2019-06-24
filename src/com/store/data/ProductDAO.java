package com.store.data;

import java.util.List;


import com.store.model.Product;

public interface ProductDAO {
	
	public List<Product> getProducts() throws Exception;

	public void addProduct(Product product) throws Exception;
	
	public void deleteProduct(int productId) throws Exception;
	
	public Product getProduct(int productId) throws Exception;
	   
	public void updateProduct(Product product) throws Exception;
	   
	public List<Product> searchProducts(String searchName) throws Exception;

}
