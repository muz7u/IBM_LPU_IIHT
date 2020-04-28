package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.ImageDAO;
import com.example.demo.model.Image;

@SpringBootApplication
@EnableDiscoveryClient
public class ImageServiceApplication implements CommandLineRunner{

	private ImageDAO imageDAO;
	
	@Autowired	
	public ImageServiceApplication(ImageDAO imageDAO) {
		super();
		this.imageDAO = imageDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(ImageServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		imageDAO.addImage(new Image("www.image1.jpg","medicine"));
		imageDAO.addImage(new Image("www.image2.jpg","food"));
		imageDAO.addImage(new Image("www.image2.jpg","cloth"));
	}

}
