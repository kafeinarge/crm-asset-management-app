package com.turkcell.crm.assetmanagement.mapper;

import com.turkcell.crm.assetmanagement.document.Order;
import com.turkcell.crm.assetmanagement.dto.ConfirmCatalogDTO;
import com.turkcell.crm.assetmanagement.mapper.base.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfirmCatalogMapper implements BaseMapper<Order,ConfirmCatalogDTO> {

    private CatalogMapper catalogMapper;

    @Autowired
    public ConfirmCatalogMapper(CatalogMapper catalogMapper) {
        this.catalogMapper = catalogMapper;
    }

    @Override
    public Order toEntity(ConfirmCatalogDTO object) {
        return Order
                .builder()
                .catalog(catalogMapper.toEntity(object.getCatalog()))
                .staticIP(object.getStaticIP())
                .build();
    }

    @Override
    public ConfirmCatalogDTO toDTO(Order object) {
        return ConfirmCatalogDTO
                .builder()
                .catalog(catalogMapper.toDTO(object.getCatalog()))
                .staticIP(object.getStaticIP())
                .build();
    }
}

