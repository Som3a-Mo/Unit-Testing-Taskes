package example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountManagerTest {

    @Test
    void shouldReturnSuccessAndUpdateBalance_whenWithdrawWithSufficientBalance() {
        // Arrange
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(1000);

        // Act
        String result = am.withdraw(c, 500);

        // Assert
        Assertions.assertEquals("success", result);
        Assertions.assertEquals(500, c.getBalance());
    }

    @Test
    void shouldReturnInsufficientBalanceMessage_whenWithdrawWithInsufficientBalanceAndCreditNotAllowed() {
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(100);
        c.setCreditAllowed(false);

        String result = am.withdraw(c, 500);

        Assertions.assertEquals("insufficient account balance", result);
    }

    @Test
    void shouldReturnMaxCreditExceededMessage_whenWithdrawWithCreditAllowedAndExceedsMaxCreditAndNotVip() {
        // Arrange
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(100);
        c.setCreditAllowed(true);

        // Act
        String result = am.withdraw(c, 2000);

        // Assert
        Assertions.assertEquals("maximum credit exceeded", result);
    }

    @Test
    void shouldReturnSuccess_whenWithdrawWithCreditAllowedExceedingMaxCreditAndVip() {
        // Arrange
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(100);
        c.setCreditAllowed(true);
        c.setVip(true);

        // Act
        String result = am.withdraw(c, 2000); // exceeds max credit

        // Assert
        Assertions.assertEquals("success", result);
        Assertions.assertEquals(-1900, c.getBalance());
    }

}
