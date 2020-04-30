package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ItemDAO;
import com.example.demo.model.Item;


@Service
public class RabbitMQConsumerService {
	private static final String QUEUE = "items-queue";

	
	public List<Item> list=new ArrayList<>();
	private ItemDAO itemDAO;
	@Autowired
	public RabbitMQConsumerService(ItemDAO itemDAO) {
		super();
		this.itemDAO = itemDAO;
	}


	@RabbitListener(queues = QUEUE)
	public void receiveMessage(Item item) {

		System.out.println("Received " + item);
			list.add(item);
			if(!list.isEmpty())
			{
			for(Item i:list)
			{
				itemDAO.save(i);
			}
			}
	}
	
	
}
