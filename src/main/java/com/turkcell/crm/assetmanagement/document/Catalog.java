package com.turkcell.crm.assetmanagement.document;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(of = "code")
@Data
public class Catalog implements Serializable {

    private String code;

    private String name;

    private Double price;

}
