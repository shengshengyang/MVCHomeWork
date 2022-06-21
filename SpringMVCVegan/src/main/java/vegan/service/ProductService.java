package vegan.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import vegan.model.Product;

public interface ProductService {
	
	public List<Product> getProduct();

	public Product getProductById(Integer productId);

	public void saveProduct(Product product, MultipartFile file) throws IOException;

	public void deleteProduct(Integer productId);
	
	public void responseFile(HttpServletResponse response, File imgFile);
	

}
