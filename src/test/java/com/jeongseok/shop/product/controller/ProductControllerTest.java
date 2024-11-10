package com.jeongseok.shop.product.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.jeongseok.shop.product.service.ProductService;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest({ProductController.class, ProductService.class }) // TODO:  테스트를 위한 클래스를 자동으로 읽어오는 방법을 고민해볼 것
class ProductControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	@DisplayName("상품 목록 호출 기능 테스트")
	void getProducts() throws Exception {
		// given
		// when

		// then
		mockMvc.perform(get("/product"))
			.andExpect(status().isOk());
	}

}