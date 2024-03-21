package Mahdi.com.salesmanagement;

import Mahdi.com.salesmanagement.model.Product;
import Mahdi.com.salesmanagement.repository.ProductRepository;
import Mahdi.com.salesmanagement.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SalesManagementApplicationTests {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetAllProducts() {
		Product product1 = new Product("Product 1", "Description 1", "Category 1");
		Product product2 = new Product("Product 2", "Description 2", "Category 2");
		productRepository.save(product1);
		productRepository.save(product2);

		List<Product> productList = productService.getAllProducts();

		Assertions.assertEquals(2, productList.size());
	}

	@Test
	void testCreateProduct() {
		Product product = new Product("New Product", "Description", "Category");
		Product createdProduct = productService.createProduct(product);

		Assertions.assertNotNull(createdProduct.getId());
		Assertions.assertEquals("New Product", createdProduct.getName());
	}
}
