package com.turkcell.crm.assetmanagement.service;

import com.turkcell.crm.assetmanagement.document.Order;
import com.turkcell.crm.assetmanagement.dto.OrderDTO;
import com.turkcell.crm.assetmanagement.mapper.OrderMapper;
import com.turkcell.crm.assetmanagement.repository.OrderRepository;
import com.turkcell.crm.assetmanagement.service.base.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    private OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDTO> findByCustomerIdentityNumber(String identityNumber) throws Exception {

        List<Order> orders = orderRepository
                .findByCustomerIdentityNumber(identityNumber)
                .orElseThrow(
                        () -> new Exception("No data found with Identity Number : " + identityNumber)
                );

        return orderMapper.toDTOList(orders);
    }
}
