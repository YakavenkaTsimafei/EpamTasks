import by.epam.lab.Purchase;
import by.epam.lab.WeekDay;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestRunner {

    @Test
    void main() {
        WeekDay[] weekDays = WeekDay.values();
        Purchase purchase = new Purchase(10, 20, weekDays[3]);
        assertEquals(20, purchase.getCost());
        assertEquals(10, purchase.getNumber());
        assertEquals(20, purchase.getPercent());
        assertEquals(WeekDay.WEDNESDAY, purchase.getWeekDay());
        String amountString = String.valueOf(purchase.getPrice() * purchase.getNumber() * (100 - purchase.getPercent()) / 100);
        assertEquals("20.4", amountString);

    }
}