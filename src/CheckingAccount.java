import java.io.Serializable;

/**
 * Checking account with no minimum balance.
 * Author: Bisman Singh <bismanmadaan1@gmail.com>
 */
public class CheckingAccount extends Account implements Serializable {
    private static final long serialVersionUID = 1L;

    public CheckingAccount(String accountNumber, String accountHolder, double initialBalance) {
        super(accountNumber, accountHolder, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}
