package OOPChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthyBurgerTest {
    private HealthyBurger testBurger = new HealthyBurger("TestMeat", 4.00);

    @Test
    void addAdditionalItem() {
        // Should only be able to add 6 additional items to healthy burger
        double itemPrice = 0.75;
        for (int i = 0; i < 7; i ++) {
            testBurger.addAdditionalItem("TestItem " + i, itemPrice);
        }
        assertEquals(6, testBurger.getAdditionalItems().size());
    }
}