package com.example.demo;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.AccountDAO;
import com.example.demo.model.Account;

@EnableDiscoveryClient
@SpringBootApplication
public class AccountClientApplication implements CommandLineRunner{

	AccountDAO accountDAO;
	
	@Autowired
	public AccountClientApplication(AccountDAO accountDAO) {
		super();
		this.accountDAO = accountDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountDAO.createAccount(new Account(UUID.randomUUID().toString(),100));
		accountDAO.createAccount(new Account(UUID.randomUUID().toString(),200));
		accountDAO.createAccount(new Account(UUID.randomUUID().toString(),300));
	}

}
