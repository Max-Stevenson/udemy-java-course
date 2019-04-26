package ArrayListChallenge;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Double> transactions = new ArrayList<>();
    private String name;

    public Customer(String name, double initialAmount) {
        this.name = name;
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

    public void setTransactions(ArrayList<Double> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction (Double amount) {
        this.transactions.add(amount);
    }
}
