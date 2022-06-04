import by.epam.lab.Purchase;
import by.epam.lab.WeekDay;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestRunner {


    @Test
    public void testGetCost() {
        Purchase purchase = new Purchase(1, 20, 3);
        assertEquals(200, Math.round(purchase.getCost() / 100) * 100);
        assertEquals(200, Math.floor(purchase.getCost() / 100) * 100);
        assertEquals(300, Math.ceil(purchase.getCost() / 100) * 100);
        Purchase purchase1 = new Purchase(1, 2.5, 3);
        assertEquals(292.5, purchase1.getCost());
    }

    @Test
    public void testPurchase() {
        Purchase purchase1 = new Purchase(1, 10, 0);
        Purchase purchase = new Purchase(1, 10, WeekDay.SUNDAY);
        assertEquals(purchase1.toString(), purchase.toString());
        Purchase purchase3 = new Purchase(1, 10, 1);
        assertEquals(purchase1.toString(), purchase3.toString());
    }

    @Test
    public void testToByn() {
        Purchase purchase = new Purchase();
        assertEquals("3.50", purchase.toByn(350));
        assertEquals("3.05", purchase.toByn(305));
        assertEquals("3.00", purchase.toByn(300));
        assertEquals("0.05", purchase.toByn(5));
        assertEquals("0.00", purchase.toByn(0));
        assertEquals("1005.00", purchase.toByn(100500));
    }
}