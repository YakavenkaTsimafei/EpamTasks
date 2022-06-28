package by.epam.lab;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestRunner {
    @Test
    public void testGetCostAndEquals() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(123);
        System.out.println(byn.equals(byn1));
        assertEquals("1.23", byn.toString());
    }

    @Test
    public void testCompareTo() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(122);
        assertEquals(-1, byn.compareTo(byn1));
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