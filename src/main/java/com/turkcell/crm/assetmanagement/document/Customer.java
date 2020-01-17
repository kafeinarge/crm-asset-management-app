package com.turkcell.crm.assetmanagement.document;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(of = "identityNumber")
@Data
public class Customer implements Serializable {

    private String name;

    private String identityNumber;

}
