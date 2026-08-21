package cuenta.bancaria.simoneaa;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    
    @Test
    public void activeAccount() {
        SavingsAccount account = new SavingsAccount(10000, 0);
        assertThat(account.isActive(), is(true));
    }

    @Test
    public void inactiveAccount() {
        SavingsAccount account = new SavingsAccount(100, 0);
        assertThat(account.isActive(), is(false));
    }

    @Test
    public void newDeposit() {
        SavingsAccount account = new SavingsAccount(10000, 0);
        account.deposit(100);
        assertThat(account.getBalance(), is(10100F));
        assertThat(account.getNumberOfDeposits(), is(1));
    }

    @Test
    public void failedDeposit() {
        SavingsAccount account = new SavingsAccount(100, 0);
        account.deposit(100);
        assertThat(account.getBalance(), is(100F));
        assertThat(account.getNumberOfDeposits(), is(0));
    }

    @Test
    public void newWithdrawal() {
        SavingsAccount account = new SavingsAccount(10000, 0);
        account.withdraw(100);
        assertThat(account.getBalance(), is(9900F));
        assertThat(account.getNumberOfWithdrawals(), is(1));
    }

    @Test
    public void newFailedWithdrawal() {
        SavingsAccount account = new SavingsAccount(100, 0);
        account.withdraw(100);
        assertThat(account.getBalance(), is(100F));
        assertThat(account.getNumberOfWithdrawals(), is(0));
    }

    @Test
    public void getMonthlyStatement() {
        SavingsAccount account = new SavingsAccount(10000, 0);
        for (int i = 0; i < 5; i++) {
            account.withdraw(100);
        }
        account.setMonthlyFee(100);
        account.monthlyStatement();
        assertThat(account.getBalance(), is(8400F));
    }

    @Test
    public void getPrint() {
        SavingsAccount account = new SavingsAccount(10000, 0);
        account.deposit(100);
        account.setMonthlyFee(100);
        assertThat(account.print(), is("Balance: 10100.0 Number of transactions: 1 Monthly fee: 100.0"));
    }

}
