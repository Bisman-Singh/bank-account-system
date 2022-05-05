import java.io.Serializable;

/**
 * Abstract base class for bank accounts.
 * Author: Bisman Singh <bismanmadaan1@gmail.com>
 */
public abstract class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public abstract void withdraw(double amount);

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}
