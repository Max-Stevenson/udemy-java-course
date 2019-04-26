package ArrayListChallenge;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branches = new ArrayList<>();

    public Bank() {

    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    public void addNewBranch(Branch branch) {
        this.getBranches().add(branch);
    }
}

