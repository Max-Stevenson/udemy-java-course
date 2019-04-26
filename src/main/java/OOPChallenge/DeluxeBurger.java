package OOPChallenge;

import java.util.HashMap;
import java.util.Map;

public class DeluxeBurger extends Hamburger {

    public DeluxeBurger( String rollType, String meatType, double price) {
        super("Deluxe Burger", rollType, meatType, price);
        Map<String, Double> deluxeAdditionals = new HashMap<>();
        deluxeAdditionals.put("Fries", 1.50);
        deluxeAdditionals.put("Drink", 1.00);
        super.setAdditionalItems(deluxeAdditionals);
    }

    @Override
    public void addAdditionalItem(String itemName, double itemPrice) {
        System.out.println("Cannot add additional items to Deluxe Burger!");
    }
}
