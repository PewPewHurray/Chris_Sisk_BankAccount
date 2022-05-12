public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        account1.depositMoney(100, "checking");
        account1.depositMoney(50, "savings");
        account2.depositMoney(500, "checking");
        account2.depositMoney(1000, "savings");
        account2.withdrawMoney(125, "checking");
        account1.withdrawMoney(100, "checking");
        account1.withdrawMoney(51, "savings");
        System.out.println("account1: \nAccount Number: " + account1.getAccountNumber());
        System.out.println(account1.display());
        System.out.println("account2: \nAccount Number: " + account2.getAccountNumber());
        System.out.println(account2.display());

        System.out.println("Number of accounts: " + BankAccount.getNumOfAccounts());
        System.out.printf("Total money in all accounts: $%.2f%n", BankAccount.getTotalMoneyInAllAccounts());
    }
}
