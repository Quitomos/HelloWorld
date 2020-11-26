package Basic;

class Account {
    protected double balance;
    public Account(double _balance) {
        balance = _balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double add) {
        balance += add;
    }

    public void withdraw(double minus) throws OverdraftException {
        balance -= minus;
        if (balance < 0) throw new OverdraftException("Over draft!", -balance);
    }
}

class OverdraftException extends Exception {
    private double deficit;
    public OverdraftException(String str, double d) {
        super(str);
        deficit = d;
    }

    public double getDeficit() {
        return deficit;
    }
}

public class ExceptionDemo {
    public static void main(String[] args) {
        Account a = new Account(10);
        a.deposit(10);
        try {
            a.withdraw(23);
        } catch (OverdraftException e) {
            e.printStackTrace();
            System.out.println(e.getDeficit());
        }
    }
}
