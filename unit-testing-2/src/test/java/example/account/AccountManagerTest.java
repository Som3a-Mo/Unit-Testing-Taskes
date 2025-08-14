package example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountManagerTest {

    @Test
    void givenCustomerWithSufficientBalance_whenWithdraw_thenSucceed() {
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
    void givenCustomerWithInsufficientBalanceAndCreditNotAllowed_whenWithdraw_thenFailed() {
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(100);
        c.setCreditAllowed(false);

        String result = am.withdraw(c, 500);

        Assertions.assertEquals("insufficient account balance", result);
    }

}
