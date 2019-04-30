package ArrayListChallenge;

public class ArrayListChallengeApp {
    public static void main (String[] args) {
        Bank bank = new Bank("TestBank");
        bank.addNewBranch("TestBranch");
        bank.getBranch("TestBranch").ifPresent(branch ->
                branch.addNewCustomer("TestCustomer", 1.00));
        bank.getBranch("TestBranch").ifPresent(branch -> {
            branch.addCustomerTransaction("TestCustomer", 2.00);
            branch.addNewCustomer("AnotherOne", 5.00);
            branch.addCustomerTransaction("AnotherOne", 2.00);
        });

        bank.showCustomersAndTransactions("TestBranch");
    }
}
