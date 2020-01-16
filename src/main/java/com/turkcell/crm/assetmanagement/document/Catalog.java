package com.turkcell.crm.assetmanagement.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(of = "code")
@Data
public class Catalog {

    private String code;

    private String name;

    private Double price;

}
