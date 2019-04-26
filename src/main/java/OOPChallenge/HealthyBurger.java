package OOPChallenge;

public class HealthyBurger extends Hamburger {

    public HealthyBurger(String meatType, double price) {
        super("Healthy Burger", "Brown Rye", meatType, price);
    }

    @Override
    public boolean canAddAdditional() {
        return (super.getAdditionalItems().size() < 6);
    }

    @Override
    public void addAdditionalItem(String itemName, double itemPrice) {
        if (this.canAddAdditional()) {
            super.addAdditionalItem(itemName, itemPrice);
        } else {
            System.out.println("You can only have 6 additional items!");
        }
    }
}
