package com.example.demo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.User;

@FeignClient("user-service")
public interface UserProxy {
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    User getUser(@PathVariable("id") Integer id);
	
}
