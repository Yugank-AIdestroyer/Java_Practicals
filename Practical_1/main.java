class BankAccount {
    private int accountNumber;
    private String holderName;
    private double balance;

    public BankAccount() {
        this.accountNumber = 1001;
        this.holderName = "Default User";
        this.balance = 0.0;
    }

    public BankAccount(int accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = 500.0;
    }

    public BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        setBalance(balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        if (accountNumber > 0) {
            this.accountNumber = accountNumber;
        }
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        if (holderName != null && !holderName.isEmpty()) {
            this.holderName = holderName;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid balance amount");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        } else {
            System.out.println("Deposit amount must be positive");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
        } else {
            System.out.println("Invalid withdraw amount");
        }
    }

    public void display() {
        System.out.println("Account: " + accountNumber + ", Name: " + holderName + ", Balance: Rs." + balance);
    }
}

public class Practical1 {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount(1002, "Rahul");
        BankAccount acc3 = new BankAccount(1003, "Priya", 2000.0);

        acc1.setHolderName("Aman");
        acc1.deposit(1500.0);
        acc2.withdraw(200.0);
        acc3.setBalance(-100.0);

        acc1.display();
        acc2.display();
        acc3.display();
    }
}
