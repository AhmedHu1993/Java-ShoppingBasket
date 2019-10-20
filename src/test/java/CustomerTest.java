import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;
    IPurchasing product1;
    IPurchasing product2;

    @Before
    public void before(){
        customer = new Customer("Ahmed");
        product1 = new Product("Cycling Gloves", "wind and water proof", 12.5, 4);
        product2 = new Product("Smart band", "Sport tracker and smart watch", 45, 5);
    }

    @Test
    public void customerHasName(){
        assertEquals("Ahmed", customer.getName());
    }

    @Test
    public void customerHasPurchaseCountStartsZero(){
        assertEquals(0, customer.getPurchaseCount());
    }

    @Test
    public void customerShoppingBasketStartsEmpty() {
        assertEquals(0 , customer.getShoppingBasket().size());
    }

    @Test
    public void testAddToBasket(){
        customer.addToBasket(product1);
        customer.addToBasket(product2);
        assertEquals(2, customer.getShoppingBasket().size());
    }

    @Test
    public void testEmptyBasket(){
        customer.addToBasket(product1);
        customer.addToBasket(product2);
        customer.emptyBasket();
        assertEquals(0, customer.getShoppingBasket().size());
    }
}
