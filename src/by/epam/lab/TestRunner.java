package by.epam.lab;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
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
        Byn[] byn = {new Byn(123),
                new Byn(145),
                new Byn(0),
                new Byn(1),
        };
        Arrays.sort(byn);
        for (Byn b : byn) {
            System.out.println(b);
        }
    }
    @Test
    public void testPurchase(){
        try (Scanner sc = new Scanner(new FileReader("src\\in.txt"))) {
            Purchase purchase = new Purchase("milk", 100, 10);
            Purchase purchase1 = PurchasesFactory.getPurchaseFromFactory(sc);
            assertEquals("milk;1.00;10;10.00",purchase1.toString());
            assertEquals("milk;1.00;10;10.00",purchase.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}