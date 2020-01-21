package com.turkcell.crm.assetmanagement.controller;

import com.turkcell.crm.assetmanagement.dto.CatalogDTO;
import com.turkcell.crm.assetmanagement.dto.ConfirmCatalogDTO;
import com.turkcell.crm.assetmanagement.dto.CustomerDTO;
import com.turkcell.crm.assetmanagement.dto.OrderListForCustomerDTO;
import com.turkcell.crm.assetmanagement.service.OrderServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    private MockMvc mockMvc;

    @Mock
    private OrderServiceImpl orderService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test(expected = Exception.class)
    public void findByCustomerId() throws Exception {

        when(orderService.findByCustomerIdentityNumber("1")).thenReturn(createOrderListCustomerDTO());
        when(orderService.findByCustomerIdentityNumber("2")).thenThrow(new Exception());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/orders?id=1").accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        MvcResult result1 = mockMvc.perform(MockMvcRequestBuilders.post("/orders?id=2").accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse response1 = result1.getResponse();
        assertNotEquals(HttpStatus.OK.value(), response1.getStatus());
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
}