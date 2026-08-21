package cuenta.bancaria.simoneaa;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AccountTest {

    @Test
    public void newDeposit() {
        Account account = new Account(0, 0);
        account.deposit(100);;
        assertThat(account.getBalance(), is(100F));
        assertThat(account.getNumberOfDeposits(), is(1));
    }

    @Test
    public void newWithdrawal() {
        Account account = new Account(100, 0);
        account.withdraw(100);
        assertThat(account.getBalance(), is(0F));
        assertThat(account.getNumberOfWithdrawals(), is(1));
    }

    @Test
    public void newFailedWithdrawal() {
        Account account = new Account(0, 0);
        account.withdraw(100);
        assertThat(account.getBalance(), is(0F));
        assertThat(account.getNumberOfWithdrawals(), is(0));
    }

    @Test
    public void checkMonthlyInterest() {
        Account account = new Account(1200, 12);
        account.calculateMonthlyInterest();
        assertThat(account.getBalance(), is(1212F));
    }

    @Test
    public void getMonthlyStatement() {
        Account account = new Account(1000, 12);
        account.setMonthlyFee(100);
        account.monthlyStatement();
        assertThat(account.getBalance(), is(909F));
    }

    @Test
    public void getPrint() {
        Account account = new Account(1000, 12);
        account.setMonthlyFee(100);
        assertThat(account.print(), is("Balance: 1000.0 Number of deposits: 0 Number of withdrawals: 0 Annual rate: 12.0 Monthly fee: 100.0"));
    }

}
