package ArrayListChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BranchTest {

    private Branch testBranch = new Branch("testBranch");

    @Test
    void addNewCustomer() {
        // Can add a single customer
        assertEquals(true, testBranch.addNewCustomer("testCustomer", 1.00));
    }

    @Test
    void duplicateCustomer() {
        //Cannot add duplicate customers (same name, different balance)
        testBranch.addNewCustomer("testCustomer", 1.00);
        assertEquals(false, testBranch.addNewCustomer("testCustomer", 2.00));
    }

    @Test
    void emptyCustomerName() {
        //Cannot create a customer with an empty name
        assertEquals(false, testBranch.addNewCustomer("", 1.00));
    }
}