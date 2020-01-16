package com.turkcell.crm.assetmanagement.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(of = "tckn")
@Data
public class Customer {

    private String name;

    private String tckn;

}
