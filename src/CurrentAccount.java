package Bank.src;

public class CurrentAccount extends Account {
    public CurrentAccount(String id, String name, int balance) {
        super(id, name, balance);
    }

    public int credit(int amount) {
        int balance = getBalance();
        balance += amount;
        return balance;
    }
    public void balanceWithInterest() {
        System.out.println("No interest Available on current account.balance:"+getBalance());
    }
    public int debit(int amount) {
        int balance = getBalance();
        if (amount <= getBalance()) {
            balance = balance - amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return getBalance();
    }

    public int transferTo(Account another, int amount) {
        int balance = getBalance();
        if (amount <= balance) {
            another.credit(amount);
            this.debit(amount);
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }

}
