package com.turkcell.crm.assetmanagement.repository;

import com.turkcell.crm.assetmanagement.document.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    Optional<List<Order>> findByCustomerIdentityNumber(String identityNumber);

}
