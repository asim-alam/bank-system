package Bank.src;

public class SavingsAccount extends Account {
    public SavingsAccount(String id, String name, int balance) {
        super(id, name, balance);
    }

    public int credit(int amount) {
        int balance = getBalance();
        balance += amount;
        return balance;
    }

    public void balanceWithInterest() {
        int balance = getBalance();
        float interest = balance * (float) 0.025;
        System.out.println("balance:" + balance + " interest:" + interest);
    }

    public int debit(int amount) {
        int balance = getBalance();
        if (amount <= getBalance() || (getBalance() - amount) > 1000) {
            balance = balance - amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return getBalance();
    }

    public int transferTo(Account another, int amount) {
        int balance = getBalance();
        if (amount <= balance || (getBalance() - amount) > 1000) {
            another.credit(amount);
            this.debit(amount);
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }
}
