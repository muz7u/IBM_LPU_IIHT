package com.ezeeshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ezeeshop.entity.Order;

@CrossOrigin("http//localhost:4200")
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
