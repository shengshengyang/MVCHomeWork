package vegan.service.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vegan.Dao.ProductDao;
import vegan.model.Product;
import vegan.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getProduct() {
		return productDao.getProduct();
	}

	@Override
	public Product getProductById(Integer productId) {
		return productDao.getProductById(productId);
	}

	@Override
	public void saveProduct(Product product) {

		productDao.saveProduct(product);
	}

	@Override
	public void deleteProduct(Integer productId) {

		productDao.deleteProduct(productId);
	}



}
