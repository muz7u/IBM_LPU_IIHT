package com.ezeeshop.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezeeshop.entity.Product;

@FeignClient("product-service")
public interface ProductClient {
	
	@GetMapping("/products")
	public Product getProductById(@RequestParam("productId") Long productId);
	
	@GetMapping("/products")
	public List<Product> getAllProducts();

}
