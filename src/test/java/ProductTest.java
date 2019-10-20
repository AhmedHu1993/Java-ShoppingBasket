import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    Product product;

    @Before
    public void before(){
        product = new Product("Cycling Gloves", "wind and water proof", 12.5, 4);
    }

    @Test
    public void hasProperties(){
        assertEquals("Cycling Gloves", product.getName());
        assertEquals("wind and water proof", product.getDescription());
        assertEquals(12.5, product.getPrice(), 0);
        assertEquals(4, product.getRating());
    }
}
