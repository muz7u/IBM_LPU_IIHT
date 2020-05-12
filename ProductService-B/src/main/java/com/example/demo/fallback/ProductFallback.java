package com.example.demo.fallback;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductCategory;
import com.example.demo.feign.FeignClient;

@Component
public class ProductFallback implements FeignClient{

		  
		  @Override
		  public ResponseEntity<List<Product>> getAllProducts() {
			  // TODO Auto-generated method stub
			  return new ResponseEntity("Service Down",HttpStatus.SERVICE_UNAVAILABLE);
			  }

		@Override
		public ResponseEntity<List<Product>> findByCategoryId(long id) {
			// TODO Auto-generated method stub
			return new ResponseEntity("Service Down",HttpStatus.SERVICE_UNAVAILABLE);
		}

		@Override
		public ResponseEntity<List<ProductCategory>> getAllCategory() {
			// TODO Auto-generated method stub
			return new ResponseEntity("Service Down",HttpStatus.SERVICE_UNAVAILABLE);
		}

		@Override
		public ResponseEntity<List<Product>> getProductsByName(String name) {
			// TODO Auto-generated method stub
			return new ResponseEntity("Service Down",HttpStatus.SERVICE_UNAVAILABLE);
		}

		@Override
		public Product getProduct(long id) {
			// TODO Auto-generated method stub
			return null;
		}
		  
}
		
