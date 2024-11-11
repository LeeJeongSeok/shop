package com.jeongseok.shop.product.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeongseok.shop.product.domain.Product;
import com.jeongseok.shop.product.repository.ProductRepository;
import com.jeongseok.shop.product.service.ProductService;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ProductController.class) // TODO:  테스트를 위한 클래스를 자동으로 읽어오는 방법을 고민해볼 것
class ProductControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	ProductService productService;

	@MockBean
	ProductRepository productRepository;

	@Test
	@DisplayName("상품 목록 호출 기능 테스트")
	void getProducts() throws Exception {
		// given
		// when

		// then
		mockMvc.perform(get("/product"))
			.andExpect(status().isOk());
	}

	@Test
	@DisplayName("상품 생성 기능 테스트")
	void createProduct() throws Exception {
		// given
		Product newProduct = new Product(3L, "상품명3", 20000, LocalDateTime.now(), LocalDateTime.now());

		// when
		String jsonProduct = objectMapper.writeValueAsString(newProduct);

		// then
		mockMvc.perform(MockMvcRequestBuilders.post("/product")
				.content(jsonProduct)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated());
	}

}