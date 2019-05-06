package AutoboxingChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BranchTest {

    private Branch testBranch = new Branch("testBranch");

    @Test
    void addNewCustomer() {
        // Can add a single customer
        assertTrue(testBranch.addNewCustomer("testCustomer", 1.00));
    }

    @Test
    void duplicateCustomer() {
        //Cannot add duplicate customers (same name, different balance)
        testBranch.addNewCustomer("testCustomer", 1.00);
        assertFalse(testBranch.addNewCustomer("testCustomer", 2.00));
    }

    @Test
    void emptyCustomerName() {
        //Cannot create a customer with an empty name
        assertFalse(testBranch.addNewCustomer("", 1.00));
    }

    @Test
    void getCustomer() {
        //Should return a pre-existing customer
        testBranch.addNewCustomer("testCustomer", 1.00);
        assertTrue(testBranch.getCustomer("testCustomer").isPresent());
        //Should not return a non-existent customer
        assertFalse(testBranch.getCustomer("nonExistent").isPresent());
    }

    @Test
    void customerTransaction() {
        //Should successfully complete for existing customer
        testBranch.addNewCustomer("testCustomer", 1.00);
        assertTrue(testBranch.addCustomerTransaction("testCustomer", 2.00));
        //Should return false if customer does not exist
        assertFalse(testBranch.addCustomerTransaction("nonExistent", 1.00));
    }
}