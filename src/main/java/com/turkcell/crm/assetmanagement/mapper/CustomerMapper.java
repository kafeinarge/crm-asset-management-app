package com.turkcell.crm.assetmanagement.mapper;

import com.turkcell.crm.assetmanagement.document.Customer;
import com.turkcell.crm.assetmanagement.dto.CustomerDTO;
import com.turkcell.crm.assetmanagement.mapper.base.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements BaseMapper<Customer, CustomerDTO> {

    @Override
    public Customer toEntity(CustomerDTO object) {

        if (object == null)
            return null;

        return Customer
                .builder()
                .name(object.getName())
                .identityNumber(object.getIdentityNumber())
                .build();
    }

    @Override
    public CustomerDTO toDTO(Customer object) {

        if (object == null)
            return null;

        return CustomerDTO
                .builder()
                .name(object.getName())
                .identityNumber(object.getIdentityNumber())
                .build();
    }

}
