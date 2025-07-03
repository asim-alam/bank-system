package Bank.src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CurrentAccount[] accountsC = new CurrentAccount[10];
        SavingsAccount[] accountsS = new SavingsAccount[10];
        DepositAccount[] accountsD = new DepositAccount[10];
        int currentCount = 0, savingsCount = 0, depositCount = 0;

        while (true) {
            System.out.println("---Account Menu---");
            System.out.println("1. Create New Account");
            System.out.println("2. Debit");
            System.out.println("3. Credit");
            System.out.println("4. Transfer to Another Account");
            System.out.println("5. Check Balance with interest");
            System.out.println("6. View Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Select Account Type:");
                    System.out.println("1. Current Account");
                    System.out.println("2. Savings Account");
                    System.out.println("3. Deposit Account");
                    int accountType = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Account ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Account Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    int balance = sc.nextInt();
                    sc.nextLine();

                    switch (accountType) {
                        case 1:
                            accountsC[currentCount++] = new CurrentAccount(id, name, balance);
                            System.out.println("Account created successfully!");
                            break;
                        case 2:
                            if (balance < 1000) {
                                System.out.println("insufficient balance");
                            } else {
                                accountsS[savingsCount++] = new SavingsAccount(id, name, balance);
                                System.out.println("Account created successfully!");
                            }
                            break;
                        case 3:
                            accountsD[depositCount++] = new DepositAccount(id, name, balance);
                            System.out.println("Account created successfully!");
                            break;
                        default:
                            System.out.println("Invalid account type!");
                    }

                    break;

                case 2:
                    System.out.print("Enter Account ID: ");
                    id = sc.nextLine();
                    System.out.print("Enter Amount to Debit: ");
                    int debitAmount = sc.nextInt();
                    sc.nextLine();

                    Account debitAccount = findAccountById(accountsC, accountsS, accountsD, currentCount, savingsCount,
                            depositCount, id);
                    if (debitAccount != null) {
                        debitAccount.debit(debitAmount);
                        System.out.println("Balance: " + debitAccount.getBalance());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account ID: ");
                    id = sc.nextLine();
                    System.out.print("Enter Amount to Credit: ");
                    int creditAmount = sc.nextInt();
                    sc.nextLine();

                    Account creditAccount = findAccountById(accountsC, accountsS, accountsD, currentCount, savingsCount,
                            depositCount, id);
                    if (creditAccount != null) {
                        creditAccount.credit(creditAmount);
                        System.out.println("Credit successful! New Balance: " + creditAccount.getBalance());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Source Account ID: ");
                    String sourceId = sc.nextLine();
                    System.out.print("Enter Destination Account ID: ");
                    String destinationId = sc.nextLine();
                    System.out.print("Enter Amount to Transfer: ");
                    int transferAmount = sc.nextInt();
                    sc.nextLine();

                    Account sourceAccount = findAccountById(accountsC, accountsS, accountsD, currentCount, savingsCount,
                            depositCount, sourceId);
                    Account destinationAccount = findAccountById(accountsC, accountsS, accountsD, currentCount,
                            savingsCount, depositCount, destinationId);

                    if (sourceAccount != null && destinationAccount != null) {
                        if (sourceAccount instanceof DepositAccount) {
                            System.out.println("Transfer not allowed from Deposit Account!");
                        } else {
                            int l = sourceAccount.transferTo(destinationAccount, transferAmount);
                            if (l == -1) {
                                System.out.println("can't transfer");
                            } else {
                                System.out.println("Transfer successful!");
                                System.out.println("Source Account Balance: " + sourceAccount.getBalance());
                                System.out.println("Destination Account Balance: " + destinationAccount.getBalance());
                            }
                        }
                    } else {
                        System.out.println("One or both accounts not found!");
                    }
                    break;
                case 5:
                    System.out.println("Enter Account Id:");
                    String accountId=sc.nextLine();
                    Account userAccount=findAccountById(accountsC, accountsS, accountsD, currentCount,
                            savingsCount, depositCount, accountId);
                    if (userAccount != null) {
                        userAccount.balanceWithInterest();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 6:
                    System.out.println("Current Accounts:");
                    for (int i = 0; i < currentCount; i++) {
                        System.out.println(accountsC[i].toString());
                    }
                    System.out.println("Savings Accounts:");
                    for (int i = 0; i < savingsCount; i++) {
                        System.out.println(accountsS[i].toString());
                    }
                    System.out.println("Deposit Accounts:");
                    for (int i = 0; i < depositCount; i++) {
                        System.out.println(accountsD[i].toString());
                    }
                    break;

                case 7:
                    System.out.println("Exiting program. Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static Account findAccountById(CurrentAccount[] accountsC, SavingsAccount[] accountsS,
            DepositAccount[] accountsD,
            int currentCount, int savingsCount, int depositCount, String id) {
        for (int i = 0; i < currentCount; i++) {
            if (accountsC[i].getId().equals(id)) {
                return accountsC[i];
            }
        }
        for (int i = 0; i < savingsCount; i++) {
            if (accountsS[i].getId().equals(id)) {
                return accountsS[i];
            }
        }
        for (int i = 0; i < depositCount; i++) {
            if (accountsD[i].getId().equals(id)) {
                return accountsD[i];
            }
        }
        return null;
    }
}
