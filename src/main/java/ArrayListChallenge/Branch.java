package ArrayListChallenge;

import java.util.ArrayList;
import java.util.Optional;

public class Branch {
    private ArrayList<Customer> customers;
    private String name;

    public Branch(String name){
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public boolean addNewCustomer(String customerName, double initialAmount) {
        if (!checkCustomerExists(customerName)) {
            if (customerName.isEmpty()) {
                System.out.println("Customer name cannot be empty!");
                return false;
            }
                Customer customer = new Customer(customerName, initialAmount);
                return this.customers.add(customer);
        }
        System.out.println("Customer already exists!");
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double transactionAmount) {
        if (checkCustomerExists(customerName)) {
            this.getCustomer(customerName).ifPresent(customer -> customer.addTransaction(transactionAmount));
            return true;
        } else {
            System.out.println("No customer exists with that name!");
            return false;
        }
    }

    public Optional<Customer> getCustomer(String customerName) {
        Optional<Customer> customer = Optional.empty();
        if (checkCustomerExists(customerName)){
           customer = this.getCustomers().stream().filter(x -> customerName.equals(x.getName())).findAny();
        }
        return customer;
    }

    public boolean checkCustomerExists (String customerName) {
        return this.customers.stream()
                .anyMatch(x -> customerName.equals(x.getName()));
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
