import java.io.*;
import java.util.*;

/**
 * Bank manages accounts and persistence.
 * Author: Bisman Singh <bismanmadaan1@gmail.com>
 */
public class Bank {
    private static final String DATA_FILE = "accounts.dat";
    private Map<String, Account> accounts = new HashMap<>();

    @SuppressWarnings("unchecked")
    public void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            accounts = (Map<String, Account>) ois.readObject();
        } catch (FileNotFoundException e) {
            accounts = new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            accounts = new HashMap<>();
        }
    }

    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.err.println("Error saving: " + e.getMessage());
        }
    }

    public void createAccount(String type, String number, String holder, double initial) {
        Account acc = type.equalsIgnoreCase("savings")
            ? new SavingsAccount(number, holder, initial)
            : new CheckingAccount(number, holder, initial);
        accounts.put(number, acc);
    }

    public Account getAccount(String number) {
        return accounts.get(number);
    }
}
