import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;
    IPurchasing product1;
    IPurchasing product2;
    IPurchasing product3;
    IPurchasing product4;
    IPurchasing product5;

    @Before
    public void before(){
        customer = new Customer("Ahmed");
        product1 = new Product("Cycling Gloves", "wind and water proof", 12.5, 4);
        product2 = new Product("Smart band", "Sport tracker and smart watch", 45, 5);
        product3 = new Product("My Lobster", "key chain from Friends Tv Series", 25, 5);
        product4 = new Product("MetWallet", "metal card holder wallet", 30.5, 3);
        product5 = new Product("Dolce Gusto", "Coffee Machine", 60, 2);
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

    @Test
    public void testRemoveProductFromBasket(){
        customer.addToBasket(product1);
        customer.addToBasket(product2);
        customer.removeFromBasket(product1);
        assertEquals(product2, customer.getShoppingBasket().get(0));
        assertEquals(1, customer.getShoppingBasket().size());
    }

    @Test
    public void testBasketTotalPriceWithNoDiscounts(){
        customer.addToBasket(product1);
        customer.addToBasket(product2);
        assertEquals(57.5, customer.totalBasketPrice(), 0);
    }

    @Test
    public void testBuyOneGetOneOddNumberOfProducts(){
        customer.addToBasket(product1);
        customer.addToBasket(product2);
        customer.addToBasket(product3);
        customer.addToBasket(product4);
        customer.addToBasket(product5);
        assertEquals(135.5, customer.totalPriceAfterBuyOneGetOne(), 0);
    }

    @Test
    public void testBuyOneGetOneEvenNumberOfProducts(){
        customer.addToBasket(product1);
        customer.addToBasket(product2);
        customer.addToBasket(product3);
        customer.addToBasket(product4);
        assertEquals(75.5, customer.totalPriceAfterBuyOneGetOne(), 0);
    }

    @Test
    public void testTenPercentDiscountOnTotalsGreaterThanTwenty(){
        customer.addToBasket(product3);
        customer.addToBasket(product2);
        assertEquals(63 , customer.getTenPercentDiscount(), 0);
    }

    @Test
    public void test2OffForLoyalCustomers(){
        customer.completePurchase();
        customer.completePurchase();
        customer.addToBasket(product3);
        customer.addToBasket(product2);
        assertEquals(68.6 , customer.getTotalPriceAfterLoyalityDiscount(), 0);
    }
}
