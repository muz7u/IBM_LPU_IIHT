package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudUserServiceApplication implements CommandLineRunner {

	private UserDao dao;
	@Autowired
	public SpringCloudUserServiceApplication(UserDao dao) {
		super();
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudUserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		dao.save(new User(111,"test111","ABC","abc@gmail.com"));
		dao.save(new User(222,"test222","XYZ","xyz@gmail.com"));
		dao.save(new User(333,"test333","EFG","efg@gmail.com"));
		dao.save(new User(444,"test444","PQR","pqr@gmail.com"));
	}

}
