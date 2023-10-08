package com.example.drools.model;

import lombok.Data;

@Data
public class Order {

	private String name;
	private String cardType;
	private int discount;
	private int price;

}
