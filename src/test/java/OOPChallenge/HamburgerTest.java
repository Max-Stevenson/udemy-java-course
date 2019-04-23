package OOPChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamburgerTest {
    private Hamburger hamburger =
            new Hamburger("TestBurger",
                    "TestRoll",
                    "TestMeat",
                    4.99);

    @Test
    void totalPriceTest() {
        double itemPrice = 0.75;
        hamburger.addAdditionalItem("TestItem", itemPrice);
        assertEquals(itemPrice + 4.99, hamburger.getTotalPrice());
    }

}