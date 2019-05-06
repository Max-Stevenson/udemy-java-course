package AutoboxingChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private Customer testCustomer = new Customer("testCustomer", 1.00);

    @Test
    void addTransaction() {
        //Customer created with an initial balance of 1.00
        testCustomer.addTransaction(2.00);
        assertEquals(2.00, testCustomer.getTransactions().get(1));
    }

    @Test
    void getBalance() {
        testCustomer.addTransaction(9.00);
        assertEquals(10.00, testCustomer.getBalance());
    }
}