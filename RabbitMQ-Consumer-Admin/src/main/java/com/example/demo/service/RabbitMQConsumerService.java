package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDAO;
import com.example.demo.model.Account;


@Service
public class RabbitMQConsumerService {
	private static final String QUEUE = "items-queue";

	
	public List<Account> list=new ArrayList<>();
	private AccountDAO accountDAO;
	@Autowired
	public RabbitMQConsumerService(AccountDAO accountDAO) {
		super();
		this.accountDAO = accountDAO;
	}


	@RabbitListener(queues = QUEUE)
	public void receiveMessage(Account account) {

		System.out.println("Received " + account);
			list.add(account);
			if(!list.isEmpty())
			{
			for(Account i:list)
			{
				accountDAO.save(i);
			}
			}
	}
	
	
}
