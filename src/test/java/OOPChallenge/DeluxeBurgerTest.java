package OOPChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeluxeBurgerTest {

    private DeluxeBurger testBurger = new DeluxeBurger("testRoll", "testMeat", 2.99);

    @Test
    void addAdditionalItem() {
        //Should not be able to add any additional items.
        testBurger.addAdditionalItem("testItem", 0.99);

        //DeluxeBurger comes with fries and drink as additional items
        assertEquals(2, testBurger.getAdditionalItems().size());
    }
}