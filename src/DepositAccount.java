package Bank.src;

public class DepositAccount extends Account {
    int installments = 1;

    public DepositAccount(String id, String name, int balance) {
        super(id, name, balance);
    }

    public int credit(int amount) {
        int balance = getBalance();
        installments++;
        balance += amount;
        return balance;
    }

    public void balanceWithInterest() {
        int balance = getBalance();
        float interest = balance * (float) 0.07;
        System.out.println("balance:" + balance + " interest:" + interest);
    }

    public int debit(int amount) {
        int balance = getBalance();
        if (installments < 5) {
            System.out.println("money withdrawal is not possible");
        } else if (amount <= getBalance()) {
            balance = balance - amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return getBalance();
    }

    @Override
    public int transferTo(Account another, int amount) {

        return -1;
    }

}
