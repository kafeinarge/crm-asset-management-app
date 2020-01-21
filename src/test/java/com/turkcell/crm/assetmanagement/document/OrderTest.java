package com.turkcell.crm.assetmanagement.document;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class OrderTest {

    private Order order;

    @Before
    public void setUp() {
        order = new Order();
        order.setStaticIP("2123456");
    }

    @Test
    public void hashCodeTest() {
        Assertions.assertNotNull(order.hashCode());
    }

    @Test
    public void toStringTest() {
        Assertions.assertNotNull(order.toString());
    }

    @Test
    public void equalsTest() {
        Order documentToCompare = createOrder();
        Customer nullRequest = null;
        Object nullObject = null;
        Assertions.assertTrue(documentToCompare.equals(order) && order.equals(documentToCompare));
        assertFalse(order.equals(nullRequest));
        assertFalse(order.equals(nullObject));
    }

    private Order createOrder() {
        Order order = new Order();
        order.setStaticIP("2123456");
        return order;
    }

}