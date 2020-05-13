package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dao.EmployeeRepository;
import com.example.domain.Employee;
import com.example.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeMongoDbApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
    private EmployeeService service;
	
	@MockBean
    private EmployeeRepository repository;

	@Test
    public void getUsersTest() {
        when(repository.findAll()).thenReturn(Stream.of(new Employee("100","Ghulam","Mozammil","mozammil@protonmail.com"), new Employee("101","Shubham","Singh","shubham@protonmail.com")).collect(Collectors.toList()));
        assertEquals(2, service.getAllEmployee().size());
    }







}
