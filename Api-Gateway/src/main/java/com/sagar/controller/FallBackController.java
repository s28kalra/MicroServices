package com.sagar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallBackController {
	
	@RequestMapping("/orderFallBack")
	public Mono<String> orderFallBack(){
		return Mono.just("order service is down or is taking too long to process");
	}
	
	@RequestMapping("/paymentFallBack")
	public Mono<String> paymentFallBack(){
		return Mono.just("payment service is down or is taking too long to process");
	}
	

}
