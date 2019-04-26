package ArrayListChallenge;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Double> transactions;
    private String name;

    public Customer(String name, double initialAmount) {
            this.name = name;
            this.transactions = new ArrayList<>();
            this.addTransaction(initialAmount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction (double amount) {
        this.transactions.add(amount);
    }
}
