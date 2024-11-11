package com.jeongseok.shop.product.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.jeongseok.shop.product.domain.Product;
import com.jeongseok.shop.product.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductServiceTest {

	@Test
	@DisplayName("상품 목록 서비스 기능 확인")
	void getProducts() {
		Product product = new Product(1L, "테스트 상품", 10000, LocalDateTime.now(), LocalDateTime.now());
		List<Product> productList = List.of(product);

		ProductRepository productRepository = mock(ProductRepository.class);
		when(productRepository.findAll()).thenReturn(productList);

		ProductService productService = new ProductService(productRepository);
		List<Product> resultList = productService.getProducts();
		assertNotNull(resultList);
		assertEquals(productList.size(), resultList.size());
		assertEquals(productList.get(0), resultList.get(0));
	}

}