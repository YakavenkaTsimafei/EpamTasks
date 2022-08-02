import by.epam.lab.*;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestSearch {
    @Test
    public void TestBinarySearch() {
        Byn cost = new Byn(100);
        Product product = new Product("milk", cost);
        AbstractPurchase[] purchases = {new PriceDiscountPurchase(product, 6, new Byn(15)),
                new PriceDiscountPurchase(product, 4, new Byn(50)),
                new PercentDiscountPurchase(product, 6, 15.5),
                new PercentDiscountPurchase(product, 4, 15.5),
                new TransportExpenseWithPurchase(product, 5, new Byn(150)),
                new TransportExpenseWithPurchase(product, 10, new Byn((250))),
        };
        Arrays.sort(purchases);
        for (AbstractPurchase p : purchases) {
            System.out.println(p);
        }
        assertEquals(0,search(purchases,new Byn(1200)));
        assertEquals(5,search(purchases,new Byn (200)));
        assertNotEquals(2,search(purchases,new Byn(400)));

    }
    private static int search(AbstractPurchase[] purchases, Byn cost) {
        int index = Arrays.binarySearch(purchases, new PercentDiscountPurchase(new Product("", cost), 1, 0) {
        });
        if (index >= 0) {
           return index;
        } else {
           return -1;
        }
    }
}