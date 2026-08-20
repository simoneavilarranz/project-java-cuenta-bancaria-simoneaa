package cuenta.bancaria.simoneaa;

public class SavingsAccount extends Account {

    private boolean active;


    public SavingsAccount(float balance, float annualRate) {

        super(balance, annualRate);

        if (balance >= 1000) {
            active = true;
        }

    }
    
}
