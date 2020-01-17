package com.turkcell.crm.assetmanagement.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Builder
@EqualsAndHashCode(of = "identityNumber")
@Data
public class CustomerDTO implements Serializable {

    private String name;

    private String identityNumber;

}
