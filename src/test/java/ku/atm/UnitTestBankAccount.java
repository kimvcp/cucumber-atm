package ku.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitTestBankAccount {

    BankAccount account;
    BankAccount account2;
    int initialBalance = 100;

    @BeforeEach
    void init() {
        account = new BankAccount(initialBalance);
        account2 = new BankAccount(initialBalance, 500);
    }

    @Test
    void testDeposit() {
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void testWithdraw() throws NotEnoughBalanceException {
        account.withdraw(30);
        assertEquals(70, account.getBalance());

        account2.withdraw(300);
        assertEquals(-200, account2.getBalance());
    }
    @Test
    @DisplayName("throws NotEnoughBalanceException when withdraw more than balance")
    void testWithdrawMoreThanBalance() {
        assertThrows(NotEnoughBalanceException.class,
                () -> account.withdraw(10000));
        assertEquals(initialBalance, account.getBalance());

        assertThrows(NotEnoughBalanceException.class,
                () -> account2.withdraw(10000));
        assertEquals(initialBalance, account2.getBalance());
    }
}
