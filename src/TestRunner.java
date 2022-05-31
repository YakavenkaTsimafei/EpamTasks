import by.epam.lab.Purchase;
import by.epam.lab.WeekDay;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestRunner {


    @Test
    public void testGetCost() {
        WeekDay[] weekDays = WeekDay.values();
        Purchase purchase = new Purchase(10, 20, weekDays[3]);
        assertEquals(2400, purchase.getCost());
    }

    @Test
    public void testPurchase() {
        WeekDay[] weekDays = WeekDay.values();
        Purchase purchase1 = new Purchase(1, 10, weekDays[0]);
        assertEquals(1, purchase1.getNumber());
        assertEquals(10, purchase1.getPercent());
        assertEquals(WeekDay.SUNDAY, weekDays[0]);
    }

    @Test
    public void testToByn() {
        Purchase purchase2 = new Purchase();
        assertEquals("3.50", purchase2.toByn(350));
    }
}