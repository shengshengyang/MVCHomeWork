package vegan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vegan.model.Product;
import vegan.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/list")
	public String listProducts(Model model) {
		List<Product> products = productService.getProduct();
		model.addAttribute("products", products);

		return "list-products";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "product-form";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("productId") Integer productId, Model model) {
		Product oneproduct = productService.getProductById(productId);
		model.addAttribute("product", oneproduct);

		return "product-form";
	}

	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.saveProduct(product);
		
		return "redirect:/product/list";
	}

	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productId") Integer productId) {
		productService.deleteProduct(productId);

		return "redirect:/product/list";
	}

}
