package vegan.Dao;

import java.util.List;

import vegan.model.Product;

public interface ProductDao {

	public List<Product> getProduct();

	public Product getProductById(Integer productId);

	public void saveProduct(Product product);

	public void deleteProduct(Integer productId);

}
