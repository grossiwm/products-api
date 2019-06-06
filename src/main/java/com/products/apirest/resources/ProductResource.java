package com.products.apirest.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.apirest.models.Product;
import com.products.apirest.repository.ProductRepository;

@RestController
@RequestMapping(value="/api")
public class ProductResource {
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	public List<Product> productsList() {
		return productRepository.findAll();
	}
	
	@GetMapping("/product/{id}")
	public Optional<Product> productListUnique(@PathVariable(value="id") long id) {
		return productRepository.findById(id);
	}
	
	@PostMapping("/products")
	public Product saveProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping("/product")
	public void deleteProduct(@RequestBody Product product) {
		productRepository.delete(product);
	}
	
	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
}
