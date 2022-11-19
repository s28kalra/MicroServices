package com.sagar.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sagar.dto.TransactionRequest;
import com.sagar.dto.TransactionResponse;
import com.sagar.entity.Order;
import com.sagar.entity.Payment;
import com.sagar.repository.OrderRepository;

@Service
@RefreshScope
public class OrderService {

	private static final Logger log = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	@Lazy
	private RestTemplate restTemplate;

	@Value("${microservice.payment-service.endpoints.endpoint.uri}")
	private String endpointURL;

	@Transactional
	public TransactionResponse saveOrder(TransactionRequest request) {
		log.info("Order Service: saveOrder(), request: {}", request);
		Order order = orderRepository.save(request.getOrder());
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		// rest call
		payment = restTemplate.postForObject(endpointURL, payment, Payment.class);
		log.info("Payment service response: {}", payment);
		String response = "payment failed";
		if (payment != null && payment.getStatus().equals("Success"))
			response = "payment Successfull";

		return TransactionResponse.builder().order(order).amount(order.getPrice())
				.transactionId(payment.getTransactionId()).message(response).build();
	}
}
