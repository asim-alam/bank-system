package Bank.src;

public abstract class Account {
    private String id;
    private String name;
    private int balance = 0;

    public Account() {

    }

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public abstract int debit(int amount);

    public abstract int credit(int amount);

    public abstract int transferTo(Account another, int amount);

    public String toString() {
        return "account" + "id:" + id + "\n" + "name:" + name + "\n" + "balance:" + balance;
    }

}
