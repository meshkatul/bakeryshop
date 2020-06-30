package org.perscholas.bakeryshop.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.perscholas.bakeryshop.models.Product;
import org.perscholas.bakeryshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("products")
public class ProductController {

	@Autowired
	ProductService productService;

	// show product page
	@RequestMapping
	public String viewProductPage(Model model) {
		List<Product> allProducts = productService.productList();
		System.out.println(allProducts.size());
		model.addAttribute("allProducts", allProducts);
		return "productPage";
	}

	// show admin product page
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String viewProductEditPage(Model model) {
		List<Product> allProducts = productService.productList();
		System.out.println(allProducts.size());
		model.addAttribute("allProducts", allProducts);
		return "productAdminPage";
	}

	// show new product page
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String showNewProductPage(Model model) {
		System.out.println("new");
		model.addAttribute("product", new Product());
		return "addNewProduct";
	}

	// adding new product
	@RequestMapping(method = RequestMethod.POST)
	public String addNewProduct(@ModelAttribute("product") Product newProduct) {
		productService.addProduct(newProduct);
		return "redirect:/products/admin";
	}

	// show update product page
	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public String viewProductUpdatePage(@PathVariable int productId, Model model) {
		Product product = productService.getProduct(productId);
		model.addAttribute("product", product);
		return "updateProduct";
	}

	// update product info
	@RequestMapping(value = "/{productId}", method = RequestMethod.POST)
	public String updateProductDetail(@PathVariable int productId, @ModelAttribute("product") Product newProduct) {
		System.out.println("Trying to update product: "+ newProduct.getProductName());
		productService.addProduct(newProduct);
		return "redirect:/products/admin";
	}
	
	// show delete product page
		@RequestMapping(value = "/delete/{productId}", method = RequestMethod.GET)
		public String viewProductDeletePage(@PathVariable int productId, Model model) {
			Product product = productService.getProduct(productId);
			model.addAttribute("product", product);
			return "deleteProduct";
		}
	
	//delete a product
	@RequestMapping(value = "/delete/{productId}", method = RequestMethod.POST)
	public String deleteProduct(@PathVariable ("productId") int productId) {
		productService.deleteProduct(productId);
		return "redirect:/products/admin";
	}
}

/*
 * //rest api
 * 
 * @PostMapping(path ="/product", consumes = "application/json", produces
 * ="application/json") public Product addProduct(@RequestBody Product
 * newProduct) { System.out.println("In post method"); return
 * productService.addProduct(newProduct); }
 * 
 * @GetMapping
 * 
 * @RequestMapping("{productId}") public @ResponseBody Product
 * getAProduct(@PathVariable("productId") int productId) {
 * System.out.println("In method"); Product product =
 * productService.getProduct(productId); return product; }
 */
