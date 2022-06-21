package vegan.service.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vegan.Dao.ProductDao;
import vegan.model.Constants;
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
	// 此時的product裡面沒有圖片的路徑
	public void saveProduct(Product product, MultipartFile file) {
		// 原始文件名
		String originalFileName = file.getOriginalFilename();
		// 取得檔名
		//String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
		// 生成UUID後加上檔名
		//String fileName = UUID.randomUUID().toString() + suffix;
		// 圖片儲存路徑
		String filePath = Constants.IMG_PATH + originalFileName;
		File saveFile = new File(filePath);
		try {
			// 把圖片保存在路徑中
			file.transferTo(saveFile);
			// 記錄檔名
			product.setProductImage(originalFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		productDao.saveProduct(product);
	}

	@Override
	public void deleteProduct(Integer productId) {

		productDao.deleteProduct(productId);
	}

}
