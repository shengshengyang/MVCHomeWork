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
	public void saveProduct(Product product, MultipartFile file) {
		// 原始文件名
		String originalFileName = file.getOriginalFilename();
		// 获取图片后缀
		String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
		// 生成图片存储的名称，UUID 避免相同图片名冲突，并加上图片后缀
		String fileName = UUID.randomUUID().toString() + suffix;
		// 图片存储路径
		String filePath = Constants.IMG_PATH + fileName;
		File saveFile = new File(filePath);
		try {
			// 将上传的文件保存到服务器文件系统
			file.transferTo(saveFile);
			// 记录服务器文件系统图片名称
			product.setProductImage(fileName);
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
