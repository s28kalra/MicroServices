package com.sagar.dto;

import com.sagar.entity.Order;
import com.sagar.entity.Payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponse {

	private Order order;
	private double amount;
	private String transactionId;
	private String message;

	
}
