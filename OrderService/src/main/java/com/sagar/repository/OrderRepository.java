package com.sagar.repository;

import org.springframework.data.repository.CrudRepository;

import com.sagar.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{

}
