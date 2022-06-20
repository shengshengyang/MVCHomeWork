package vegan.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import vegan.model.Product;

public interface ProductService {
	
	public List<Product> getProduct();

	public Product getProductById(Integer productId);

	public void saveProduct(Product product, MultipartFile file);

	public void deleteProduct(Integer productId);
	

}
