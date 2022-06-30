import by.epam.lab.*;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TestRunner {
    @Test
    public void testEquals() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(123);
        Byn byn2 = new Byn(3);
        Purchase purchase = new Purchase("milk", byn, 10);
        PurchaseWithADiscount purchaseWithADiscount = new PurchaseWithADiscount("milk", byn, 10, byn1);
        PurchaseWithADiscountDependingOnTheQuantity p = new PurchaseWithADiscountDependingOnTheQuantity("milk", byn, 10, 15.5);
        Purchase purchase1 = new Purchase("0il", byn, 10);
        assertEquals(byn, byn1);
        assertEquals(purchase, purchaseWithADiscount);
        assertEquals(purchase, p);
        assertNotEquals(purchase1, p);
        assertNotEquals(purchase1, purchase);
        assertNotEquals(purchase1, purchaseWithADiscount);
        assertNotEquals(byn2, byn);
        assertNotEquals(byn2, byn1);
    }

    @Test
    public void testToString() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(100);
        Purchase purchase = new Purchase("milk", byn, 10);
        PurchaseWithADiscount purchaseWithADiscount = new PurchaseWithADiscount("milk", byn, 10, byn1);
        PurchaseWithADiscountDependingOnTheQuantity p = new PurchaseWithADiscountDependingOnTheQuantity("milk", byn, 10, 15.5);
        assertEquals("milk;1.23;10;12.30", purchase.toString());
        assertEquals("milk;1.23;10;1.00;2.30", purchaseWithADiscount.toString());
        assertEquals("milk;1.23;10;15.5;10.39", p.toString());
        assertEquals("123", byn.toString());
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
    }

    @Test
    public void testGetCostPurchaseWithADiscount() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(100);
        Byn byn2 = new Byn(230);
        PurchaseWithADiscount purchaseWithADiscount = new PurchaseWithADiscount("milk", byn, 10, byn1);
        assertEquals(byn2, purchaseWithADiscount.getCost());
    }

    @Test
    public void testGetCostPurchaseWithADiscountDependingOnTheQuantity() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(1039);
        PurchaseWithADiscountDependingOnTheQuantity p = new PurchaseWithADiscountDependingOnTheQuantity("milk", byn, 10, 15.5);
        assertEquals(byn1, p.getCost());
    }

    @Test
    public void testPurchaseFactory() {
        try (Scanner sc = new Scanner(new FileReader("src\\in.txt"))) {
            Purchase[] purchases = new Purchase[6];
            int i = 0;
            while (sc.hasNext()) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                i++;
            }
            assertEquals("milk;1.00;10;10.00", purchases[0].toString());
            assertEquals("bread;5.00;4;12.4;20.00", purchases[2].toString());
            assertEquals("cheese;2.00;3;0.50;4.50", purchases[4].toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMltp() {
        Byn byn = new Byn(100);
        assertEquals("10.00", byn.mltp(10).toString());
    }

    @Test
    public void testDifference() {
        Byn byn = new Byn(100);
        Byn byn1 = new Byn(50);
        assertEquals("5.00", byn.difference(byn1, 10).toString());
    }

    @Test
    public void testDiscount() {
        Byn byn = new Byn(100);
        Byn byn1 = new Byn(20);
        assertEquals("8.00", byn.difference(byn1, 10).toString());
    }

    @Test
    public void testPurchase() {
        try (Scanner sc = new Scanner(new FileReader("src\\in.txt"))) {
            Byn byn = new Byn(100);
            Purchase purchase = new Purchase("milk", byn, 10);
            Purchase purchase1 = PurchasesFactory.getPurchaseFromFactory(sc);
            assertEquals("milk;1.00;10;10.00", purchase1.toString());
            assertEquals("milk;1.00;10;10.00", purchase.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}