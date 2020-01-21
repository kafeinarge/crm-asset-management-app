package com.turkcell.crm.assetmanagement.mapper;

import com.turkcell.crm.assetmanagement.document.Customer;
import com.turkcell.crm.assetmanagement.document.Order;
import com.turkcell.crm.assetmanagement.dto.OrderListForCustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderListForCustomerMapper {

    private CustomerMapper customerMapper;

    private ConfirmCatalogMapper confirmCatalogMapper;

    @Autowired
    public OrderListForCustomerMapper(CustomerMapper customerMapper, ConfirmCatalogMapper confirmCatalogMapper) {
        this.customerMapper = customerMapper;
        this.confirmCatalogMapper = confirmCatalogMapper;
    }

    public OrderListForCustomerDTO orderToOrderList(List<Order> orderList, Customer customer){
        return OrderListForCustomerDTO
                .builder()
                .customer(customerMapper.toDTO(customer))
                .confirmCatalogDTOList(confirmCatalogMapper.toDTOList(orderList))
                .build();
    }

}
