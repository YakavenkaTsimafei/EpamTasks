import by.epam.lab.*;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TestRunner {
    @Test
    public void testEqualsByn() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(123);
        Byn byn2 = new Byn(3);
        assertEquals(byn, byn1);
        assertNotEquals(byn2, byn);
        assertNotEquals(byn2, byn1);
    }

    @Test
    public void testEqualsPurchase() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(123);
        Purchase purchase = new Purchase("milk", byn, 10);
        PriceDiscountPurchase priceDiscountPurchase = new PriceDiscountPurchase("milk", byn, 10, byn1);
        PercentDiscountPurchase percentDiscountPurchase = new PercentDiscountPurchase("milk", byn, 10, 15.5);
        Purchase purchase1 = new Purchase("0il", byn, 10);
        assertEquals(purchase, priceDiscountPurchase);
        assertEquals(purchase, percentDiscountPurchase);
        assertNotEquals(purchase1, purchase);

    }

    @Test
    public void testEqualsPurchaseWithADiscount() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(123);
        Purchase purchase = new Purchase("milk", byn, 10);
        PriceDiscountPurchase priceDiscountPurchase = new PriceDiscountPurchase("milk", byn, 10, byn1);
        Purchase purchase1 = new Purchase("0il", byn, 10);
        assertEquals(purchase, priceDiscountPurchase);
        assertNotEquals(purchase1, priceDiscountPurchase);
    }

    @Test
    public void testEqualsPurchaseWithADiscountDependingOnTheQuantity() {
        Byn byn = new Byn(123);
        Purchase purchase = new Purchase("milk", byn, 10);
        PercentDiscountPurchase percentDiscountPurchase = new PercentDiscountPurchase("milk", byn, 10, 15.5);
        Purchase purchase1 = new Purchase("0il", byn, 10);
        assertEquals(purchase, percentDiscountPurchase);
        assertNotEquals(purchase1, percentDiscountPurchase);

    }

    @Test
    public void testToStringPurchaseWithADiscount() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(100);
        PriceDiscountPurchase priceDiscountPurchase = new PriceDiscountPurchase("milk", byn, 10, byn1);
        assertEquals("PriceDiscountPurchase;milk;1.23;10;1.00;2.30", priceDiscountPurchase.toString());
    }

    @Test
    public void testToStringPurchaseWithADiscountDependingOnTheQuantity() {
        Byn byn = new Byn(123);
        PercentDiscountPurchase percentDiscountPurchase = new PercentDiscountPurchase("milk", byn, 10, 15.5);
        assertEquals("PercentDiscountPurchase;milk;1.23;10;15.5;11.00", percentDiscountPurchase.toString());
    }

    @Test
    public void testToStringPurchase() {
        Byn byn = new Byn(123);
        Purchase purchase = new Purchase("milk", byn, 10);
        assertEquals("Purchase;milk;1.23;10;12.30", purchase.toString());
    }

    @Test
    public void testToStringByn() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(1, 23);
        assertEquals("1.23", byn.toString());
        assertEquals("1.23", byn1.toString());
    }

    @Test
    public void testCompareTo() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(122);
        Byn byn2 = new Byn(100);
        assertEquals(-1, byn.compareTo(byn1));
        assertNotEquals(12, byn2.compareTo(byn));
        assertNotEquals(12, byn2.compareTo(byn1));

    }

    @Test
    public void testGetCostPurchase() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(1230);
        Purchase purchase = new Purchase("milk", byn, 10);
        assertEquals(byn1, purchase.getCost());
        assertEquals(byn, purchase.getPrice());
    }

    @Test
    public void testGetCostPriceDiscountPurchase() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(100);
        Byn byn2 = new Byn(230);
        PriceDiscountPurchase priceDiscountPurchase = new PriceDiscountPurchase("milk", byn, 10, byn1);
        assertEquals(byn2, priceDiscountPurchase.getCost());
        assertEquals(byn, priceDiscountPurchase.getPrice());
    }

    @Test
    public void testGetCostPercentDiscountPurchase() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(1100);
        Byn byn2 = new Byn(369);
        PercentDiscountPurchase percentDiscountPurchase = new PercentDiscountPurchase("milk", byn, 10, 15.5);
        PercentDiscountPurchase percentDiscountPurchase1 = new PercentDiscountPurchase("milk", byn, 3, 15.5);
        assertEquals(byn1, percentDiscountPurchase.getCost());
        assertEquals(byn2, percentDiscountPurchase1.getCost());
        assertEquals(byn, percentDiscountPurchase1.getPrice());
        assertEquals(byn, percentDiscountPurchase1.getPrice());
    }

    @Test
    public void testPurchaseFactory() {
        try (Scanner sc = new Scanner(new FileReader("src\\in.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            Purchase[] purchases = new Purchase[6];
            int i = 0;
            while (sc.hasNext()) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                i++;
            }
            assertEquals("Purchase;milk;1.00;10;10.00", purchases[0].toString());
            assertEquals("PercentDiscountPurchase;bread;5.00;4;12.4;20.00", purchases[2].toString());
            assertEquals("PriceDiscountPurchase;cheese;2.00;3;0.50;4.50", purchases[4].toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMul() {
        Byn byn = new Byn(100);
        assertEquals("10.00", byn.mul(10).toString());
    }

    @Test
    public void testAdd() {
        Byn byn = new Byn(100);
        Byn byn1 = new Byn(50);
        assertEquals("1.50", byn.add(byn1).toString());
    }

    @Test
    public void testSub() {
        Byn byn = new Byn(1000);
        Byn byn1 = new Byn(200);
        assertEquals("8.00", byn.sub(byn1).toString());
    }

    @Test
    public void testMulDouble() {
        Byn byn = new Byn(1000);
        double x = 16.6;
        assertEquals("8.40", byn.mul((100 - x) / 100, Method.RoundMethod.CEIL, 1).toString());
    }

    @Test
    public void testRound() {
        Byn byn = new Byn(775);
        assertEquals("7.80", byn.round(Method.RoundMethod.CEIL, 1).toString());
    }


    @Test
    public void testGetRubs() {
        Byn byn = new Byn(1234);
        assertEquals(12, byn.getRubs());

    }

    @Test
    public void testGetCoins() {
        Byn byn = new Byn(1234);
        assertEquals(34, byn.getCoins());

    }

}