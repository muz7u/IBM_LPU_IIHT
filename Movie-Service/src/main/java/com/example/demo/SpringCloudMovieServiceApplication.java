package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.MovieDao;
import com.example.demo.model.Movie;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SpringCloudMovieServiceApplication implements CommandLineRunner {

	private MovieDao dao;
	@Autowired
	public SpringCloudMovieServiceApplication(MovieDao dao) {
		super();
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudMovieServiceApplication.class, args);
	}
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		dao.save(new Movie("Once Upon a Time in Hollywood",2019,"Drama"));
		dao.save(new Movie("Ford Vs Ferrari",2019,"Biography"));
		dao.save(new Movie("Good Will Hunting",1997,"Drama/Romance"));
		dao.save(new Movie("Million Dollar Baby",2004,"Drama/Sports"));
		dao.save(new Movie("Pulp Fiction",1994,"Drama/Crime"));
		dao.save(new Movie("Meet Joe Black",1998,"Drama/Fantasy"));
	}

}
