package org.perscholas.bakeryshop.service;

import java.util.List;

import org.perscholas.bakeryshop.models.Product;
import org.perscholas.bakeryshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	//get all products
	public List<Product> productList(){
		return productRepository.findAll();
	}
	
	//get a product by id
	public Product getProduct(int productId) {
		Product product = productRepository.findById(productId).get();
		return product;
	}
	
	//add a product
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	//delete a product
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}

}
