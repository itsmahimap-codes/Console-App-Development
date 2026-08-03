import java.util.ArrayList;
import java.util.Scanner;

public class BankManagementSystem {

    // Account class
    static class Account {
        int accountNumber;
        String name;
        double balance;

        Account(int accountNumber, String name, double balance) {
            this.accountNumber = accountNumber;
            this.name = name;
            this.balance = balance;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n========== BANK MANAGEMENT SYSTEM ==========");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Search Account");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    accounts.add(new Account(accNo, name, balance));

                    System.out.println("Account Created Successfully!");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();

                    boolean found = false;

                    for (Account a : accounts) {
                        if (a.accountNumber == accNo) {
                            System.out.print("Enter Deposit Amount: ");
                            double amount = sc.nextDouble();

                            a.balance = a.balance + amount;

                            System.out.println("Deposit Successful!");
                            System.out.println("Current Balance: ₹" + a.balance);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Account Not Found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();

                    found = false;

                    for (Account a : accounts) {
                        if (a.accountNumber == accNo) {
                            System.out.print("Enter Withdrawal Amount: ");
                            double amount = sc.nextDouble();

                            if (amount <= a.balance) {
                                a.balance = a.balance - amount;
                                System.out.println("Withdrawal Successful!");
                                System.out.println("Current Balance: ₹" + a.balance);
                            } else {
                                System.out.println("Insufficient Balance!");
                            }

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Account Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();

                    found = false;

                    for (Account a : accounts) {
                        if (a.accountNumber == accNo) {
                            System.out.println("\n----- Account Details -----");
                            System.out.println("Account Number : " + a.accountNumber);
                            System.out.println("Customer Name  : " + a.name);
                            System.out.println("Balance        : ₹" + a.balance);

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Account Not Found!");
                    }
                    break;

                case 5:
                    if (accounts.isEmpty()) {
                        System.out.println("No Accounts Available!");
                    } else {
                        System.out.println("\n===== ALL ACCOUNTS =====");

                        for (Account a : accounts) {
                            System.out.println("---------------------------");
                            System.out.println("Account Number : " + a.accountNumber);
                            System.out.println("Customer Name  : " + a.name);
                            System.out.println("Balance        : ₹" + a.balance);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using Bank Management System!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
