package ca.ubc.cpsc210.grocery.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


// Unit tests for the GroceryBill class
class GroceryBillTest {
    GroceryBill b1;

    GroceryItem milk;
    GroceryItem cereal;
    GroceryItem eggs;

    @BeforeEach
    void runBefore() {
        b1 = new GroceryBill();

        milk = new GroceryItem("Milk", 500);
        cereal = new GroceryItem("Cereal", 350);
        eggs = new GroceryItem("Eggs", 235);
    }

    @Test
    public void testConstructor() {
        assertEquals(0,b1.getNumLineItems());
        assertEquals(0,b1.getTotalNumberOfItemsPurchased());
    }

    @Test
    public void testAddSinglePurchase() {
        b1.addPurchase(milk,1);

        assertEquals(1,b1.getNumLineItems());
        assertEquals(1,b1.getTotalNumberOfItemsPurchased());
        assertEquals(1,b1.getTotalQuantityOfItemPurchased(milk));
    }

    @Test
    public void testAddMultiplePurchase() {
        b1.addPurchase(cereal,1);
        b1.addPurchase(eggs,3);

        assertEquals(2,b1.getNumLineItems());
        assertEquals(4,b1.getTotalNumberOfItemsPurchased());
        assertEquals(1,b1.getTotalQuantityOfItemPurchased(milk));
        assertEquals(3,b1.getTotalQuantityOfItemPurchased(eggs));
    }

    @Test
    public void testGetTotalNumberOfItemsPurchased() {
        b1.addPurchase(milk,2);
        b1.addPurchase(cereal,3);
        b1.addPurchase(eggs,10);
        b1.addPurchase(milk,1);

        assertEquals(16,b1.getTotalNumberOfItemsPurchased());
    }

    @Test
    public void testGetNumLineItems() {
        b1.addPurchase(milk,2);
        b1.addPurchase(cereal,3);
        b1.addPurchase(eggs,10);
        b1.addPurchase(milk,1);

        assertEquals(3,b1.getNumLineItems());
    }

    @Test
    public void testGetTotalQuantityOfItemPurchased() {
        b1.addPurchase(milk,2);
        b1.addPurchase(cereal,3);
        b1.addPurchase(eggs,10);
        b1.addPurchase(milk,1);

        assertEquals(3,b1.getTotalQuantityOfItemPurchased(milk));
        assertEquals(3,b1.getTotalQuantityOfItemPurchased(cereal));
        assertEquals(10,b1.getTotalQuantityOfItemPurchased(eggs));
    }

    @Test
    public void testToString() {
        b1.addPurchase(milk,1);
        assertEquals("1x Milk @ $5.00\n", b1.toString());
        b1.addPurchase(milk,3);
        assertEquals("4x Milk @ $5.00\n" , b1.toString());
        b1.addPurchase(cereal,1);
        assertEquals("4x Milk @ $5.00\n1x Cereal @ $3.50\n", b1.toString());
    }
}