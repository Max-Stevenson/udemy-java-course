package OOPChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamburgerTest {
    private Hamburger hamburger = new Hamburger("TestBurger", "TestRoll", "TestMeat", 4.99);

    @Test
    void totalPriceTest() {
        // Should return price of all additional items and base cost of burger
        double itemPrice = 0.75;
        hamburger.addAdditionalItem("TestItem", itemPrice);
        assertEquals(itemPrice + 4.99, hamburger.getTotalPrice());
    }

    @Test
    void additionalItemTest() {
        //Should only be able to add 4 additional items to hamburger
        double itemPrice = 0.75;
        for (int i = 0; i < 5; i ++) {
            hamburger.addAdditionalItem("TestItem " + i, itemPrice);
        }
        assertEquals(4, hamburger.getAdditionalItems().size());
    }
}
