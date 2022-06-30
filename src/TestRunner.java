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
        PurchaseWithADiscount purchaseWithADiscount = new PurchaseWithADiscount("milk", byn, 10, byn1);
        PurchaseWithADiscountDependingOnTheQuantity p = new PurchaseWithADiscountDependingOnTheQuantity("milk", byn, 10, 15.5);
        Purchase purchase1 = new Purchase("0il", byn, 10);
        assertEquals(purchase, purchaseWithADiscount);
        assertEquals(purchase, p);
        assertNotEquals(purchase1, purchase);

    }

    @Test
    public void testEqualsPurchaseWithADiscount() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(123);
        Purchase purchase = new Purchase("milk", byn, 10);
        PurchaseWithADiscount purchaseWithADiscount = new PurchaseWithADiscount("milk", byn, 10, byn1);
        Purchase purchase1 = new Purchase("0il", byn, 10);
        assertEquals(purchase, purchaseWithADiscount);
        assertNotEquals(purchase1, purchaseWithADiscount);
    }
        @Test
        public void testEqualsPurchaseWithADiscountDependingOnTheQuantity () {
            Byn byn = new Byn(123);
            Purchase purchase = new Purchase("milk", byn, 10);
            PurchaseWithADiscountDependingOnTheQuantity p = new PurchaseWithADiscountDependingOnTheQuantity("milk", byn, 10, 15.5);
            Purchase purchase1 = new Purchase("0il", byn, 10);
            assertEquals(purchase, p);
            assertNotEquals(purchase1, p);

        }

        @Test
        public void testToStringPurchaseWithADiscount () {
            Byn byn = new Byn(123);
            Byn byn1 = new Byn(100);
            PurchaseWithADiscount purchaseWithADiscount = new PurchaseWithADiscount("milk", byn, 10, byn1);
            assertEquals("PurchaseWithADiscount;milk;1.23;10;1.00;2.30", purchaseWithADiscount.toString());
        }

        @Test
        public void testToStringPurchaseWithADiscountDependingOnTheQuantity () {
            Byn byn = new Byn(123);
            PurchaseWithADiscountDependingOnTheQuantity p = new PurchaseWithADiscountDependingOnTheQuantity("milk", byn, 10, 15.5);
            assertEquals("PurchaseWithADiscountDependingOnTheQuantity;milk;1.23;10;15.5;10.39", p.toString());
        }

        @Test
        public void testToStringPurchase () {
            Byn byn = new Byn(123);
            Purchase purchase = new Purchase("milk", byn, 10);
            assertEquals("milk;1.23;10;12.30", purchase.toString());
        }

        @Test
        public void testToStringByn () {
            Byn byn = new Byn(123);
            assertEquals("1.23", byn.toString());
        }

        @Test
        public void testCompareTo () {
            Byn byn = new Byn(123);
            Byn byn1 = new Byn(122);
            Byn byn2 = new Byn(100);
            assertEquals(-1, byn.compareTo(byn1));
            assertNotEquals(12, byn2.compareTo(byn));
            assertNotEquals(12, byn2.compareTo(byn1));

        }

        @Test
        public void testGetCostPurchase () {
            Byn byn = new Byn(123);
            Byn byn1 = new Byn(1230);
            Purchase purchase = new Purchase("milk", byn, 10);
            assertEquals(byn1, purchase.getCost());
        }

        @Test
        public void testGetCostPurchaseWithADiscount () {
            Byn byn = new Byn(123);
            Byn byn1 = new Byn(100);
            Byn byn2 = new Byn(230);
            PurchaseWithADiscount purchaseWithADiscount = new PurchaseWithADiscount("milk", byn, 10, byn1);
            assertEquals(byn2, purchaseWithADiscount.getCost());
        }

        @Test
        public void testGetCostPurchaseWithADiscountDependingOnTheQuantity () {
            Byn byn = new Byn(123);
            Byn byn1 = new Byn(1039);
            Byn byn2 = new Byn(369);
            PurchaseWithADiscountDependingOnTheQuantity p = new PurchaseWithADiscountDependingOnTheQuantity("milk", byn, 10, 15.5);
            PurchaseWithADiscountDependingOnTheQuantity p1 = new PurchaseWithADiscountDependingOnTheQuantity("milk", byn, 3, 15.5);
            assertEquals(byn1, p.getCost());
            assertEquals(byn2, p1.getCost());
        }

        @Test
        public void testPurchaseFactory () {
            try (Scanner sc = new Scanner(new FileReader("src\\in.txt"))) {
                sc.useLocale(Locale.ENGLISH);
                Purchase[] purchases = new Purchase[6];
                int i = 0;
                while (sc.hasNext()) {
                    purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                    i++;
                }
                assertEquals("milk;1.00;10;10.00", purchases[0].toString());
                assertEquals("PurchaseWithADiscountDependingOnTheQuantity;bread;5.00;4;12.4;20.00", purchases[2].toString());
                assertEquals("PurchaseWithADiscount;cheese;2.00;3;0.50;4.50", purchases[4].toString());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Test
        public void testMltp () {
            Byn byn = new Byn(100);
            assertEquals("10.00", byn.mltp(10).toString());
        }

        @Test
        public void testDifference () {
            Byn byn = new Byn(100);
            Byn byn1 = new Byn(50);
            assertEquals("5.00", byn.difference(byn1, 10).toString());
        }

        @Test
        public void testDiscount () {
            Byn byn = new Byn(100);
            Byn byn1 = new Byn(20);
            assertEquals("8.00", byn.difference(byn1, 10).toString());
        }
    }