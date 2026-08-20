package cuenta.bancaria.simoneaa;

public class SavingsAccount extends Account {

    private boolean active;

    public SavingsAccount(float balance, float annualRate) {

        super(balance, annualRate);

        if (balance >= 10000) {
            active = true;
        } else active = false;

    }

    @Override
    public void deposit(float amount) {
        if (active) {
            super.deposit(amount);
        }
    }

    @Override
    public void withdraw(float amount) {
        if (active) {
            super.withdraw(amount);
        }
    }

    @Override
    public void monthlyStatement() {
        if (numberOfWithdrawals > 4) {
            monthlyFee = monthlyFee+(numberOfWithdrawals-4)*1000;
        } super.monthlyStatement();
        if (balance >= 10000) {
            active = true;
        } else active = false;
    }

    @Override
    public String print() {
        String values = "Balance: " + balance + " Number of transactions: " + numberOfDeposits+numberOfWithdrawals + " Monthly fee: " + monthlyFee;
        return values;
    }
    
}
