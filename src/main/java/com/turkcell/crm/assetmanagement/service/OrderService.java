package com.turkcell.crm.assetmanagement.service;

import com.turkcell.crm.assetmanagement.document.Order;
import com.turkcell.crm.assetmanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order) {

        return orderRepository.save(order);

    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

}
