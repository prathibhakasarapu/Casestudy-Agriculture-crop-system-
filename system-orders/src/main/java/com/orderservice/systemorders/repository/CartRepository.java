package com.orderservice.systemorders.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.orderservice.systemorders.model.Cart;

public interface CartRepository extends MongoRepository<Cart , String>{
	List<Cart> findByDealerId(String dealerId);
}
