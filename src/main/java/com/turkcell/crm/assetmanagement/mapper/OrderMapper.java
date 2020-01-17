package com.turkcell.crm.assetmanagement.mapper;

import com.turkcell.crm.assetmanagement.document.Order;
import com.turkcell.crm.assetmanagement.dto.OrderDTO;
import com.turkcell.crm.assetmanagement.mapper.base.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements BaseMapper<Order, OrderDTO> {

    private CustomerMapper customerMapper;

    private CatalogMapper catalogMapper;

    @Autowired
    public OrderMapper(CustomerMapper customerMapper, CatalogMapper catalogMapper) {
        this.customerMapper = customerMapper;
        this.catalogMapper = catalogMapper;
    }

    @Override
    public Order toEntity(OrderDTO object) {

        if (object == null)
            return null;

        return Order
                .builder()
                .catalog(
                        catalogMapper
                                .toEntity(object.getCatalog())
                )
                .customer(
                        customerMapper
                                .toEntity(object.getCustomer())
                )
                .staticIP(object.getStaticIP())
                .build();

    }

    @Override
    public OrderDTO toDTO(Order object) {

        if (object == null)
            return null;

        return OrderDTO
                .builder()
                .id(object.getId())
                .catalog(
                        catalogMapper
                                .toDTO(object.getCatalog())
                )
                .customer(
                        customerMapper
                                .toDTO(object.getCustomer())
                )
                .staticIP(object.getStaticIP())
                .createdAt(object.getCreatedAt())
                .updatedAt(object.getUpdatedAt())
                .build();

    }
}
