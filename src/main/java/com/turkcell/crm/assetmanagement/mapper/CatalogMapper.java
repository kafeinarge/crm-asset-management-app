package com.turkcell.crm.assetmanagement.mapper;

import com.turkcell.crm.assetmanagement.document.Catalog;
import com.turkcell.crm.assetmanagement.dto.CatalogDTO;
import com.turkcell.crm.assetmanagement.mapper.base.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public class CatalogMapper implements BaseMapper<Catalog, CatalogDTO> {

    @Override
    public Catalog toEntity(CatalogDTO object) {

        if (object == null)
            return null;

        return Catalog
                .builder()
                .code(object.getCode())
                .name(object.getName())
                .price(object.getPrice())
                .build();
    }

    @Override
    public CatalogDTO toDTO(Catalog object) {

        if (object == null)
            return null;

        return CatalogDTO
                .builder()
                .code(object.getCode())
                .name(object.getName())
                .price(object.getPrice())
                .build();
    }

}
