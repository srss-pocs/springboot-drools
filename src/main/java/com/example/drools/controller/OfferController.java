package com.example.drools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.drools.model.Order;
import com.example.drools.service.OrderDiscountService;

@RestController
@RequestMapping("/api")
public class OfferController {

	@Autowired
	OrderDiscountService orderDiscountService;

	@PostMapping("/getDiscount")
	public ResponseEntity<Order> getDiscount(@RequestBody Order order) {
		return new ResponseEntity<>(orderDiscountService.getDiscount(order), HttpStatus.OK);
	}

}
