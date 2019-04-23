package OOPChallenge;

import java.util.HashMap;
import java.util.Map;

public class Hamburger {
    private String nameOfBurger;
    private String rollType;
    private String meatType;
    private double price;
    private Map<String, Double> additionalItems = new HashMap<>();

    public Hamburger(String nameOfBurger, String rollType, String meatType, double price) {
        this.nameOfBurger = nameOfBurger;
        this.rollType = rollType;
        this.meatType = meatType;
        this.price = price;
    }

    public String getNameOfBurger() {
        return nameOfBurger;
    }

    public void setNameOfBurger(String nameOfBurger) {
        this.nameOfBurger = nameOfBurger;
    }

    public String getRollType() {
        return rollType;
    }

    public void setRollType(String rollType) {
        this.rollType = rollType;
    }

    public String getMeatType() {
        return meatType;
    }

    public void setMeatType(String meatType) {
        this.meatType = meatType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Map<String, Double> getAdditionalItems() {
        return additionalItems;
    }

    public void setAdditionalItems(Map<String, Double> additionalItems) {
        this.additionalItems = additionalItems;
    }

    public void addAdditionalItem(String itemName, double itemPrice) {
        this.additionalItems.put(itemName, itemPrice);
    }

    public double getTotalPrice() {
        return this.additionalItems.values().stream().reduce(0.0, Double::sum) + this.getPrice();
    }
}
