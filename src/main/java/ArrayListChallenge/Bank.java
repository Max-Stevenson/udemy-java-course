package ArrayListChallenge;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

public class Bank {
    private ArrayList<Branch> branches;
    private String name;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    public boolean addNewBranch(String branchName) {
        if(!checkBranchExists(branchName)) {
            if(branchName.isEmpty()) {
                System.out.println("Branch name cannot be empty!");
                return false;
            }
            Branch branch = new Branch(branchName);
            return this.getBranches().add(branch);
        }
        System.out.println("Branch already exists with that name!");
        return false;
    }

    public boolean checkBranchExists(String branchName) {
        return this.branches.stream()
                .anyMatch(x -> branchName.equals(x.getName()));
    }

    public Optional<Branch> getBranch(String branchName) {
        Optional<Branch> branch = Optional.empty();
        if (checkBranchExists(branchName)){
            branch = this.getBranches().stream().filter(x -> branchName.equals(x.getName())).findAny();
        }
        return branch;
    }

    public void showCustomersAndTransactions(String branchName) {
        Optional<Branch> branch = getBranch(branchName);
        branch.ifPresent(x -> {
            x.getCustomers().forEach(y -> System.out.println(y.getName()));
            x.getCustomers().forEach(customer -> customer.getTransactions().forEach(System.out::println));
                });

    }
}

