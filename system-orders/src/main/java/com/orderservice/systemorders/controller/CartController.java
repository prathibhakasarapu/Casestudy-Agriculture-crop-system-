package com.orderservice.systemorders.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.systemorders.model.Cart;
import com.orderservice.systemorders.repository.CartRepository;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/apicart")
public class CartController {
  @Autowired
  CartRepository repo;
  
  @RequestMapping(value="/getcart",method=RequestMethod.GET)
  public List<Cart> getAllCart() {
	  return repo.findAll();
  }
  
  @RequestMapping(value="/dealerCart/{dealerId}",method=RequestMethod.GET)
  public List<Cart> getByFarmerId(@PathVariable String dealerId) {
	return repo.findByDealerId(dealerId);
  }

  @RequestMapping(value="/addtocart",method=RequestMethod.POST)
  public void addOrders(@RequestBody Cart cart) {
	  repo.insert(cart);
  }

  @RequestMapping(value="/deletecart",method=RequestMethod.DELETE)
  public void deleteorders() {
    repo.deleteAll();
  }
  
  @RequestMapping(value="/deletecart/{id}",method=RequestMethod.DELETE)
  public void deleteCropsDetails(@PathVariable String id) {
    repo.deleteById(id);
  }

  

}
