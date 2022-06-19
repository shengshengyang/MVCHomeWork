package vegan.service;

import java.util.List;

import vegan.model.Product;

public interface ProductService {
	
	public List<Product> getProduct();

	public Product getProductById(Integer productId);

	public void saveProduct(Product product);

	public void deleteProduct(Integer productId);

}
