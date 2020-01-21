package com.turkcell.crm.assetmanagement.service.base;

import com.turkcell.crm.assetmanagement.dto.OrderListForCustomerDTO;

public interface OrderService {

    OrderListForCustomerDTO findByCustomerIdentityNumber(String identityNumber) throws Exception;
}
