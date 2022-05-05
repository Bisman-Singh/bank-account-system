import java.io.Serializable;

/**
 * Savings account with minimum balance requirement.
 * Author: Bisman Singh <bismanmadaan1@gmail.com>
 */
public class SavingsAccount extends Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final double MIN_BALANCE = 100.0;

    public SavingsAccount(String accountNumber, String accountHolder, double initialBalance) {
        super(accountNumber, accountHolder, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
            balance -= amount;
        }
    }
}
