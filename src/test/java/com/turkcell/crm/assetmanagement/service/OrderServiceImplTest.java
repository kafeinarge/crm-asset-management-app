package com.turkcell.crm.assetmanagement.service;

import com.turkcell.crm.assetmanagement.document.Catalog;
import com.turkcell.crm.assetmanagement.document.Customer;
import com.turkcell.crm.assetmanagement.document.Order;
import com.turkcell.crm.assetmanagement.dto.CatalogDTO;
import com.turkcell.crm.assetmanagement.dto.ConfirmCatalogDTO;
import com.turkcell.crm.assetmanagement.dto.CustomerDTO;
import com.turkcell.crm.assetmanagement.dto.OrderListForCustomerDTO;
import com.turkcell.crm.assetmanagement.repository.OrderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = Exception.class)
    public void findByCustomerIdentityNumberTest() throws Exception {

        when(orderRepository.findByCustomerIdentityNumber("1")).thenReturn(createOrderList());
        when(orderRepository.findByCustomerIdentityNumber("2")).thenThrow(new Exception());
        Assert.assertEquals(orderService.findByCustomerIdentityNumber("1"),createOrderListCustomerDTO());
        Assert.assertNotEquals(orderService.findByCustomerIdentityNumber("2"),createOrderListCustomerDTO());
    }

    private List<Order> createOrderList(){
        List<Order> orders = new ArrayList<>();
        orders.add(createOrderExp1());
        orders.add(createOrderExp2());
        return orders;
    }

    private Order createOrderExp1(){
        Order order = new Order();
        order.setCatalog(createCatalogExp1());
        order.setCustomer(createCustomer());
        order.setStaticIP("445679946");
        return order;
    }
    private Order createOrderExp2(){
        Order order = new Order();
        order.setCatalog(createCatalogExp2());
        order.setCustomer(createCustomer());
        order.setStaticIP("445679946");
        return order;
    }

    private OrderListForCustomerDTO createOrderListCustomerDTO() {
        return OrderListForCustomerDTO
                .builder()
                .customer(createCustomerDTO())
                .confirmCatalogDTOList(createConfirmCatalogDTOList())
                .build();
    }

    private CustomerDTO createCustomerDTO() {
        return CustomerDTO
                .builder()
                .identityNumber("1")
                .name("John")
                .build();
    }

    private Customer createCustomer() {
        return Customer
                .builder()
                .identityNumber("1")
                .name("John")
                .build();
    }

    private List<ConfirmCatalogDTO> createConfirmCatalogDTOList() {
        List<ConfirmCatalogDTO> confirmCatalogDTOList = new ArrayList<>();
        confirmCatalogDTOList.add(
                ConfirmCatalogDTO
                        .builder()
                        .staticIP("445679946")
                        .catalog(createCatalogExp1DTO())
                        .build());
        confirmCatalogDTOList.add(
                ConfirmCatalogDTO
                        .builder()
                        .staticIP("342454523")
                        .catalog(createCatalogExp2DTO())
                        .build());
        return confirmCatalogDTOList;

    }

    private CatalogDTO createCatalogExp1DTO() {
        return CatalogDTO
                .builder()
                .code("123")
                .name("TVPlus")
                .price(12.5)
                .build();
    }

    private CatalogDTO createCatalogExp2DTO() {
        return CatalogDTO
                .builder()
                .code("456")
                .name("Fiber")
                .price(12.5)
                .build();
    }

    private Catalog createCatalogExp1() {
        return Catalog
                .builder()
                .code("123")
                .name("TVPlus")
                .price(12.5)
                .build();
    }

    private Catalog createCatalogExp2() {
        return Catalog
                .builder()
                .code("456")
                .name("Fiber")
                .price(12.5)
                .build();
    }


}