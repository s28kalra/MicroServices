package com.sagar.repository;

import org.springframework.data.repository.CrudRepository;

import com.sagar.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer>{

	Payment findByOrderId(int orderId);

}
