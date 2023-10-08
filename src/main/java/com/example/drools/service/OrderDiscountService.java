package com.example.drools.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.drools.model.Order;

@Service
public class OrderDiscountService {

    @Autowired
    private KieContainer kieContainer;

    public Order getDiscount(Order order) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(order);
        kieSession.fireAllRules();
        return order;
    }
}
