# Bank Account Management System

## Overview
This project is a simple **Bank Account Management System** implemented in Java. It allows users to create and manage three types of accounts: **Current Account**, **Savings Account**, and **Deposit Premium Account**. The system supports operations such as account creation, debit, credit, and money transfer, with specific rules for each account type.

## Features
1. **Account Types**:
   - **Current Account**:
     - No interest.
     - Can withdraw the entire balance.
   - **Savings Account**:
     - 2.5% interest.
     - Must maintain a minimum balance of 1000.
   - **Deposit Premium Account**:
     - 7% interest.
     - Cannot withdraw before completing all 5 installments.
     - Cannot transfer money to other accounts.

2. **Operations**:
   - **Create Account**: Create a new account of any type.
   - **Debit**: Withdraw money from an account.
   - **Credit**: Deposit money into an account.
   - **Transfer**: Transfer money between accounts (not allowed for Deposit Premium Accounts).
   - **View Accounts**: Display all accounts grouped by type.

## Requirements
- **Java Development Kit (JDK)** 8 or higher.
- **IntelliJ IDEA** or any Java IDE for development and execution.

## How to Run
1. Clone the repository or download the project files.
2. Open the project in your Java IDE (e.g., IntelliJ IDEA).
3. Compile and run the `Main.java` file.
4. Follow the on-screen menu to perform operations.

## Rules and Restrictions
- **Savings Account**:
  - Cannot debit if the balance falls below 1000 after the transaction.
- **Deposit Premium Account**:
  - Cannot withdraw money before completing 5 installments.
  - Cannot transfer money to other accounts.
- **Current Account**:
  - No restrictions on withdrawal or transfer.

## Example Usage
1. Create a new account:
   - Choose the account type (Current, Savings, or Deposit Premium).
   - Enter account details (ID, name, and initial balance).
2. Perform operations:
   - Debit or credit money to/from an account.
   - Transfer money between accounts (except from Deposit Premium Accounts).
3. View all accounts:
   - Displays all accounts grouped by type.

## License
This project is for educational purposes and is not licensed for commercial use.
