package com.ezeeshop.rabbitService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezeeshop.dao.OrderRepository;
import com.ezeeshop.entity.Order;


@Service
public class RabbitMQConsumerService {
	private static final String QUEUE = "order-queue";

	
	private OrderRepository orderRepository;

	@Autowired
	public RabbitMQConsumerService(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}



	@RabbitListener(queues = QUEUE)
	public void receiveMessage(Order objOrder) {
		System.out.println("Received " + objOrder);
		orderRepository.save(objOrder);
		}
}

