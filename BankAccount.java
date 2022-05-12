import java.util.Random;

public class BankAccount {
    private static Random randMachine = new Random();
    private static int numOfAccounts = 0;
    private static double totalMoneyInAllAccounts = 0;
    private double checkingBalance = 0;
    private double savingsBalance = 0;
    private String accountNumber = "";

    public BankAccount(){
        BankAccount.numOfAccounts += 1;
        this.accountNumber = randomAccountNumber();
    }

    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public void depositMoney(double amount, String account){
        if (account.equals("checking")){
            this.checkingBalance += amount;
        } else if (account.equals("savings")) {
            this.savingsBalance += amount;
        }
        BankAccount.totalMoneyInAllAccounts += amount;
    }

    public void withdrawMoney(double amount, String account){
        boolean successful = false;
        if (account.equals("checking")){
            if (this.checkingBalance >= amount){
                this.checkingBalance -= amount;
                successful = true;
            }
        } else if (account.equals("savings")){
            if (this.savingsBalance >= amount){
                this.savingsBalance -= amount;
                successful = true;
            }
        }
        if (successful){
            BankAccount.totalMoneyInAllAccounts -= amount;
        }
    }

    public String display(){
        return String.format("Checking: $%.2f%nSavings: $%.2f%n", this.getCheckingBalance(), this.getSavingsBalance());
    }

    private String randomAccountNumber(){
        String numberString = "";
        int[] numbers = BankAccount.randMachine.ints(10, 0, 10).toArray();
        for (int n : numbers){
            numberString = numberString + n;
        }
        return numberString;
    }

    public static int getNumOfAccounts(){
        return BankAccount.numOfAccounts;
    }

    public static double getTotalMoneyInAllAccounts(){
        return BankAccount.totalMoneyInAllAccounts;
    }
}