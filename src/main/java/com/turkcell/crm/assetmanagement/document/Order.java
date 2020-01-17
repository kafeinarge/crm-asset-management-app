package com.turkcell.crm.assetmanagement.document;

import com.turkcell.crm.assetmanagement.document.base.BaseEntity;
import lombok.*;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "orders")
public class Order extends BaseEntity {

    @Field("customer")
    private Customer customer;

    @Field("catalog")
    private Catalog catalog;

    @Indexed(direction = IndexDirection.ASCENDING)
    private String staticIP;

}
