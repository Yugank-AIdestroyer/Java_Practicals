class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class AccountUtility {
    public static int totalTransactions = 0;
    public final double MIN_BALANCE = 1000.0;
    private double balance;

    public AccountUtility(double balance) {
        this.balance = balance;
    }

    public static void showTransactionCount() {
        System.out.println("Total Transactions: " + totalTransactions);
    }

    public final void showMinBalanceRule() {
        System.out.println("Minimum required balance is: " + MIN_BALANCE);
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero");
        }
        if (balance - amount < MIN_BALANCE) {
            throw new InsufficientFundsException("Withdrawal breaks minimum balance rule");
        }
        balance = balance - amount;
        totalTransactions++;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }
}

public class Practical6 {
    public static void main(String[] args) {
        AccountUtility acc = new AccountUtility(3000.0);
        acc.showMinBalanceRule();

        try {
            acc.withdraw(1500.0);
            acc.withdraw(1000.0);
        } catch (InvalidAmountException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Domain Error: " + e.getMessage());
        } finally {
            AccountUtility.showTransactionCount();
            System.out.println("Transaction session ended");
        }
    }
}
