package com.turkcell.crm.assetmanagement.service;

import com.mongodb.MongoException;
import com.turkcell.crm.assetmanagement.document.Order;
import com.turkcell.crm.assetmanagement.dto.OrderListForCustomerDTO;
import com.turkcell.crm.assetmanagement.mapper.OrderListForCustomerMapper;
import com.turkcell.crm.assetmanagement.repository.OrderRepository;
import com.turkcell.crm.assetmanagement.service.base.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    private OrderListForCustomerMapper orderListForCustomerMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderListForCustomerMapper orderListForCustomerMapper) {
        this.orderRepository = orderRepository;
        this.orderListForCustomerMapper = orderListForCustomerMapper;
    }

    @Override
    public OrderListForCustomerDTO findByCustomerIdentityNumber(String identityNumber) throws Exception {

        List<Order> orders = orderRepository
                .findByCustomerIdentityNumber(identityNumber);
        if(orders.isEmpty()){
            throw new Exception("No data found with Identity Number : " + identityNumber);
        }
        return orderListForCustomerMapper.orderToOrderList(orders,orders.get(0).getCustomer());
    }
}
