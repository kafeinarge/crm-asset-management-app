package com.turkcell.crm.assetmanagement.dto.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Data
public abstract class BaseDTO implements Serializable {

    private String id;

    private Date createdAt;

    private Date updatedAt;

}
