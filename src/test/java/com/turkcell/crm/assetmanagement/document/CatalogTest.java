package com.turkcell.crm.assetmanagement.document;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class CatalogTest {

    private Catalog catalog;

    @Before
    public void setUp() {
        catalog = new Catalog();
        catalog.setName("Fiber");
        catalog.setCode("123");
        catalog.setPrice(11.11);
    }

    @Test
    public void hashCodeTest() {
        Assertions.assertNotNull(catalog.hashCode());
    }

    @Test
    public void toStringTest() {
        Assertions.assertNotNull(catalog.toString());
    }

    @Test
    public void equalsTest() {
        Catalog documentToCompare = createCatalog();
        Catalog nullRequest = null;
        Object nullObject = null;
        Assertions.assertTrue(documentToCompare.equals(catalog) && catalog.equals(documentToCompare));
        assertFalse(catalog.equals(nullRequest));
        assertFalse(catalog.equals(nullObject));
    }

    private Catalog createCatalog() {
        Catalog catalog = new Catalog();
        catalog.setName("Fiber");
        catalog.setCode("123");
        catalog.setPrice(11.11);
        return catalog;
    }

}