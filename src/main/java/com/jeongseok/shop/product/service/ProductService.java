package com.jeongseok.shop.product.service;

import com.jeongseok.shop.product.domain.Product;
import com.jeongseok.shop.product.repository.ProductRepository;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public void saveProduct(Product product) {
		productRepository.save(product);
	}
}
