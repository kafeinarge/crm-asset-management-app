package com.turkcell.crm.assetmanagement.service.base;

import com.turkcell.crm.assetmanagement.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> findByCustomerIdentityNumber(String identityNumber) throws Exception;

}
