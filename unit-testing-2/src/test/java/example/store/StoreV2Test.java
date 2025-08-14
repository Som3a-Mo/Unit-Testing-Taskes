package example.store;

import example.account.AccountManager;
import example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class StoreV2Test {

    @Test
    void test() {
        // Arrange
        AccountManager accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("success");
        Store store = new StoreImpl(accountManager);
        Product product = new Product();
        product.setQuantity(4);
        Customer customer = new Customer();

        // Act
        store.buy(product, customer);

        // Assert
        assertEquals(3, product.getQuantity());
    }

    @Test
    void givenProductWithInsufficientQuantity_whenBuy_thenFailed (){

        AccountManager accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("success");
        Store store = new StoreImpl(accountManager);
        Product product = new Product();
        product.setQuantity(0);
        Customer customer = new Customer();

        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> store.buy(product, customer)
        );

        assertEquals("Product out of stock", ex.getMessage());
    }

    @Test
    void givenProductWithSufficientQuantityAndFailedWithdraw_whenBuy_thenFailed() {
        // Arrange
        AccountManager accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("insufficient account balance");
        Store store = new StoreImpl(accountManager);
        Product product = new Product();
        product.setQuantity(4);
        Customer customer = new Customer();

        // Act
        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> store.buy(product, customer)
        );

        // Assert
        assertEquals("Payment failure: insufficient account balance", ex.getMessage());
    }
}
