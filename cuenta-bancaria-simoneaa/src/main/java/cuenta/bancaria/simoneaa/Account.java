package cuenta.bancaria.simoneaa;

public class Account {

    protected float balance;
    protected int numberOfDeposits;
    protected int numberOfWithdrawals;
    protected float annualRate;
    protected float monthlyFee;

    public Account(float balance, float annualRate) {

        this.balance = balance;
        this.annualRate = annualRate;
        this.numberOfDeposits = 0;
        this.numberOfWithdrawals = 0;
        this.monthlyFee = 0;

    }

    public void deposit(float amount) {

        this.balance += amount;
        this.numberOfDeposits++;

    }

    public void withdraw(float amount) {

        if (balance >= amount) {
            this.balance -= amount;
            this.numberOfWithdrawals++;   
        }

    }

    public void calculateMonthlyInterest() {

        float monthlyInterest = balance * annualRate / 12 / 100;
        this.balance += monthlyInterest;

    }

    public void monthlyStatement() {

        this.balance -= monthlyFee;
        calculateMonthlyInterest();

    }
    
}
