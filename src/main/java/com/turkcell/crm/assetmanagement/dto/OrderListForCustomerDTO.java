package com.turkcell.crm.assetmanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.turkcell.crm.assetmanagement.dto.base.BaseDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderListForCustomerDTO extends BaseDTO {

    private CustomerDTO customer;

    private List<ConfirmCatalogDTO> confirmCatalogDTOList;

    @Builder
    public OrderListForCustomerDTO(List<ConfirmCatalogDTO> confirmCatalogDTOList,CustomerDTO customer,String id, Date createdAt, Date updatedAt) {
        super(id, createdAt, updatedAt);
        this.confirmCatalogDTOList = confirmCatalogDTOList;
        this.customer = customer;
    }
}
