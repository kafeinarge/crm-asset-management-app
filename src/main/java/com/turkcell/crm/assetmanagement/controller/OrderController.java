package com.turkcell.crm.assetmanagement.controller;

import com.turkcell.crm.assetmanagement.dto.Response;
import com.turkcell.crm.assetmanagement.service.base.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Response findByCustomerId(@RequestParam("id") String id) throws Exception {

        return Response
                .builder()
                .httpStatus(HttpStatus.OK.value())
                .data(
                        orderService.findByCustomerIdentityNumber(id)
                )
                .build();

    }

}
