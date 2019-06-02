package CollectionsChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerInterfaceTest {

    private CustomerInterface testInterface = new CustomerInterface();
    private Basket testBasket = new Basket("testBasket");

    @Test
    void SellItem() {
        // Should not sell an item that does not exist.
        assertEquals(0, testInterface.sellItem(testBasket, "nonExistent", 1));
        // Normal function should return quantity added to basket.
        assertEquals(1, testInterface.sellItem(testBasket, "Bread", 1));
        // Can only sell as many items as is in stock.
        assertEquals(1, testInterface.sellItem(testBasket, "RarePepe", 1));
        assertEquals(0, testInterface.sellItem(testBasket, "RarePepe", 1));
    }

    @Test
    void removeItem() {
        // Should not remove an item that does not exist.
        assertEquals(0, testInterface.removeItem(testBasket, "nonExistent", 1));
        // Normal function should return back quantity requested to remove.
        // Stock levels initialized in constructor of CustomerInterface.
        testInterface.sellItem(testBasket, "Bread", 1);
        assertEquals(1, testInterface.removeItem(testBasket, "Bread", 1));
    }

    @Test
    void checkout() {

    }
}