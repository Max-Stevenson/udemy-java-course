package AutoboxingChallenge;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    private Bank testBank = new Bank("testBank");

    @Test
    void addNewBranch() {
        //Should not add a branch if one already exists with that name
        //Should not allow an empty branch name.
        ArrayList<Branch> branches = new ArrayList<>();
        branches.add(new Branch("testBranch"));
        testBank.setBranches(branches);
        assertFalse(testBank.addNewBranch("testBranch"));
        assertFalse(testBank.addNewBranch(""));
        assertTrue(testBank.addNewBranch("AnotherTestBranch"));
    }

    @Test
    void checkBranchExists() {
        //Should return true for branches that exist and false for those that don't
        testBank.addNewBranch("testBranch");
        assertTrue(testBank.checkBranchExists("testBranch"));
        assertFalse(testBank.checkBranchExists("nonExistent"));
    }

    @Test
    void addCustomerTransactionNonCustomer() {
        //Should not add for non existent customers
        testBank.addNewBranch("testBranch");
        testBank.addCustomerTransaction("testBranch", "nonExistent", 1.00);
        Optional <Branch> testBranch = testBank.getBranch("testBranch");
        assertFalse(testBranch.get().checkCustomerExists("nonExistent"));
    }

    @Test
    void addCustomerTransactionCustomer() {
        //Should add for customers that exist
        testBank.addNewBranch("testBranch");
        Optional <Branch> testBranch = testBank.getBranch("testBranch");
        testBranch.get().addNewCustomer("doesExist", 1.00);
        testBank.addCustomerTransaction("testBranch", "doesExist", 2.00);
        assertEquals(2.00, testBranch.get().getCustomer("doesExist").get().getTransactions().get(1));
    }
}