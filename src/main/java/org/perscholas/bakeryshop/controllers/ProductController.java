package org.perscholas.bakeryshop.controllers;

import org.perscholas.bakeryshop.models.Product;
import org.perscholas.bakeryshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping(path ="/product", consumes = "application/json", produces = "application/json")
		public Product addProduct(@RequestBody Product newProduct) {
		System.out.println("In post method");
		return productService.addProduct(newProduct);
	}
	
	@GetMapping
	@RequestMapping("{productId}")
	public @ResponseBody Product getAProduct(@PathVariable("productId") int productId) {
		System.out.println("In method");
		Product product = productService.getProduct(productId);
		return product;
	}

}
