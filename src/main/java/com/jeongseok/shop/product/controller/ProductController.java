package com.jeongseok.shop.product.controller;

import com.jeongseok.shop.product.domain.Product;
import com.jeongseok.shop.product.service.ProductService;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping("/product")
	public List<Product> getProducts() {
		return productService.getProducts();
	}

	@PostMapping("/product")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody Product product) {
		productService.saveProduct(product);
	}

}
