package ArrayListChallenge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    private Bank testBank = new Bank("testBank");

    @Test
    void addNewBranch() {
        //Should not add a branch if one already exists with that name.
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
    }
}