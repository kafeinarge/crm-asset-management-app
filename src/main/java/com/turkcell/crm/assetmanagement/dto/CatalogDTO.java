package com.turkcell.crm.assetmanagement.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Builder
@EqualsAndHashCode(of = "code")
@Data
public class CatalogDTO implements Serializable {

    private String code;

    private String name;

    private Double price;

}
