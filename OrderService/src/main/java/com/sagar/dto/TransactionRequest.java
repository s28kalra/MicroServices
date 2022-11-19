package com.sagar.dto;

import com.sagar.entity.Order;
import com.sagar.entity.Payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionRequest {
	
	private Order order;
	private Payment payment;

}
