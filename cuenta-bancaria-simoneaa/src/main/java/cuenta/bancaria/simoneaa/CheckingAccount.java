package cuenta.bancaria.simoneaa;

public class CheckingAccount extends Account {

    private float overdraft;

    public CheckingAccount(float balance, float annualRate) {
        super(balance, annualRate);
    }

    @Override
    public void withdraw(float amount) {

        if (balance <= amount) {
            this.overdraft = amount - balance;
            this.balance = 0;
        } else {this.balance -= amount;}
        this.numberOfWithdrawals++; 

    }

    @Override
    public void deposit(float amount) {

        if (overdraft == 0) {
            super.deposit(amount);
        }   else if (amount > overdraft) {
            this.overdraft = 0;
            amount = amount - overdraft;
            super.deposit(amount);
        }   else if (amount <= overdraft) {
            overdraft = overdraft - amount;
        }

    }

    @Override
    public void monthlyStatement() {
        super.monthlyStatement();
    }

    @Override
    public String print() {
        String values = "Balance: " + balance + " Number of transactions: " + numberOfDeposits+numberOfWithdrawals + 
        " Monthly fee: " + monthlyFee + " Overdraft: " + overdraft;
        return values;
    }

}
