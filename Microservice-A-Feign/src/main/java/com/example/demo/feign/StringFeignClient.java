package com.example.demo.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.fallback.StringFallback;
import com.example.demo.model.Employee;

@FeignClient(value ="service-B", fallback = StringFallback.class)
public interface StringFeignClient {

	@RequestMapping("/api/string/hi")
	public String callHi(@RequestParam String name);
	
	@RequestMapping("/api/find")
	public ResponseEntity<Iterable<Employee>> callFindEmployeeByDepartmentName(@RequestParam String name);
	
	@PostMapping("/api/employees")
	public ResponseEntity<Employee> callEmployees(@RequestBody Employee employee);
}
