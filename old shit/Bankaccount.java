public class Bankaccount {
    private String accountnum;
    private double balance;
    public Bankaccount(String accountnum, double initialbalance) {
        this.accountnum = accountnum;
        this.balance = initialbalance;


    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);

        } else {
            System.out.println("Invalid deposit amount");
        }

    }

    public void wtihdrawl(double withdrawamount) {
        if (withdrawamount > 0 && withdrawamount <= balance) {
            balance -= withdrawamount;
            System.out.println("Withdrawn: " + withdrawamount);

        } else {
            System.out.println("Invalid withdrawal amount or insuffient funds");
        }

    }


    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountnum;
    }
    public void printAccountInfo() {
        System.out.println("Account Number: "+accountnum);
        System.out.println("Balance: "+balance);
    }


}
