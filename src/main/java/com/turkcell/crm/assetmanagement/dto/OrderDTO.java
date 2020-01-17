package com.turkcell.crm.assetmanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.turkcell.crm.assetmanagement.dto.base.BaseDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDTO extends BaseDTO {

    private CustomerDTO customer;

    private CatalogDTO catalog;

    private String staticIP;

    @Builder
    public OrderDTO(CustomerDTO customer, CatalogDTO catalog, String staticIP, String id,
                    Date createdAt, Date updatedAt) {
        super(id, createdAt, updatedAt);
        this.customer = customer;
        this.catalog = catalog;
        this.staticIP = staticIP;
    }
}
