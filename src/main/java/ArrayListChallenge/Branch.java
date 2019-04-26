package ArrayListChallenge;

import java.util.ArrayList;

public class Branch {
    private ArrayList<Customer> customers = new ArrayList<>();

    public Branch(){

    }

    public void addNewCustomer(Customer customer, Double transactionAmount) {
        customer.addTransaction(transactionAmount);
        this.customers.add(customer);
    }
}
