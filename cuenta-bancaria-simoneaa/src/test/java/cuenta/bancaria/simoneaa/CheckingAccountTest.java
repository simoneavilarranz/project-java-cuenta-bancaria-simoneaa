package cuenta.bancaria.simoneaa;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class CheckingAccountTest {
    @Test
    public void newDeposit() {
        CheckingAccount account = new CheckingAccount(0, 0);
        account.deposit(100);
        assertThat(account.getBalance(), is(100F));
        assertThat(account.getNumberOfDeposits(), is(1));
    }

    @Test
    public void newOverdraftDeposit() {
        CheckingAccount account = new CheckingAccount(0, 0);
        account.withdraw(50);
        account.deposit(100);
        assertThat(account.getBalance(), is(50F));
        assertThat(account.getNumberOfDeposits(), is(1));
    }

    @Test
    public void getPrint() {
        CheckingAccount account = new CheckingAccount(50, 0);
        account.withdraw(100);
        account.setMonthlyFee(100);
        assertThat(account.print(), is("Balance: 0.0 Number of transactions: 1 Monthly fee: 100.0 Overdraft: 50.0"));
    }
}
