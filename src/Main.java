import java.util.Scanner;

/**
 * Bank Account System - Menu-driven CLI.
 * Author: Bisman Singh <bismanmadaan1@gmail.com>
 */
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.load();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Bank Account System ===");
            System.out.println("1. Create account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance");
            System.out.println("5. Quit");
            System.out.print("Choice: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Type (savings/checking): ");
                    String type = sc.nextLine().trim();
                    System.out.print("Account number: ");
                    String num = sc.nextLine().trim();
                    System.out.print("Holder name: ");
                    String holder = sc.nextLine().trim();
                    System.out.print("Initial balance: ");
                    double init = Double.parseDouble(sc.nextLine().trim());
                    bank.createAccount(type, num, holder, init);
                    bank.save();
                    System.out.println("Account created.");
                    break;
                case "2":
                    System.out.print("Account number: ");
                    Account acc2 = bank.getAccount(sc.nextLine().trim());
                    if (acc2 == null) {
                        System.out.println("Account not found.");
                        break;
                    }
                    System.out.print("Amount: ");
                    double dep = Double.parseDouble(sc.nextLine().trim());
                    acc2.deposit(dep);
                    bank.save();
                    System.out.println("Deposited.");
                    break;
                case "3":
                    System.out.print("Account number: ");
                    Account acc3 = bank.getAccount(sc.nextLine().trim());
                    if (acc3 == null) {
                        System.out.println("Account not found.");
                        break;
                    }
                    System.out.print("Amount: ");
                    double wd = Double.parseDouble(sc.nextLine().trim());
                    acc3.withdraw(wd);
                    bank.save();
                    System.out.println("Withdrawn.");
                    break;
                case "4":
                    System.out.print("Account number: ");
                    Account acc4 = bank.getAccount(sc.nextLine().trim());
                    if (acc4 == null) {
                        System.out.println("Account not found.");
                        break;
                    }
                    System.out.println("Balance: " + acc4.getBalance());
                    break;
                case "5":
                    bank.save();
                    System.out.println("Goodbye.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
