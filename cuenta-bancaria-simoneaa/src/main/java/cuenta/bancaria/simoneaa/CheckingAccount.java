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
}
