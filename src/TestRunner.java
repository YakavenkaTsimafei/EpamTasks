import by.epam.lab.Purchase;
import by.epam.lab.WeekDay;
import org.junit.jupiter.api.Test;

import static by.epam.lab.ToByn.toByn;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestRunner {


    @Test
    public void testGetCost() {
        Purchase purchase = new Purchase(1, 20, 3);
        assertEquals(200, Math.round(purchase.getCost() / 100) * 100);
        assertEquals(200, Math.floor(purchase.getCost() / 100) * 100);
        assertEquals(300, Math.ceil(purchase.getCost() / 100) * 100);
        Purchase purchase1 = new Purchase(1, 2.5, 3);
        assertEquals(300, purchase1.getCost());
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
        assertEquals("3.50", toByn(350));
        assertEquals("3.05", toByn(305));
        assertEquals("3.00", toByn(300));
        assertEquals("0.05", toByn(5));
        assertEquals("0.00", toByn(0));
        assertEquals("1005.00", toByn(100500));
    }
}