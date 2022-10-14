import by.epam.lab.Byn;
import by.epam.lab.Purchase;
import by.epam.lab.PurchaseList;
import by.epam.lab.PurchasesFactory;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TestRunner {
    @Test
    public void testAddingANewPurchase() {
        PurchaseList purchaseList = new PurchaseList("src\\by\\epam\\lab\\ information.txt");
        purchaseList.addingANewPurchase(12, new Purchase("bread", new Byn(60), 6));
        purchaseList.addingANewPurchase(5, new Purchase("cheese", new Byn(50), 2));
        purchaseList.addingANewPurchase(-2, new Purchase("water", new Byn(60), 6));
        Assertions.assertEquals("water;0.60;6;3.60", purchaseList.getPurchaseList().get(0).toString());
        Assertions.assertEquals("cheese;0.50;2;1.00", purchaseList.getPurchaseList().get(6).toString());
        Assertions.assertEquals("bread;0.60;6;3.60", purchaseList.getPurchaseList().get(10).toString());

    }

    @Test
    public void testRemovingFromTheGap() {
        PurchaseList purchaseList = new PurchaseList("src\\by\\epam\\lab\\ information.txt");
        purchaseList.removingFromTheGap(-1, 2);
        purchaseList.removingFromTheGap(1, 99);
        Assertions.assertEquals("bread;1.54;3;4.62", purchaseList.getPurchaseList().get(0).toString());
    }

    @Test
    public void testTotalCoast() {
        PurchaseList purchaseList = new PurchaseList("src\\by\\epam\\lab\\ information.txt");
        Assertions.assertEquals(4782, purchaseList.totalCost().getValue());
    }

    @Test
    public void testSortList() {
        PurchaseList purchaseList = new PurchaseList("src\\by\\epam\\lab\\ information.txt");
        purchaseList.sortList();
        Assertions.assertEquals("bread;1.55;1;0.02;1.53", purchaseList.getPurchaseList().get(0).toString());
        Assertions.assertEquals("bread;1.45;5;7.25", purchaseList.getPurchaseList().get(7).toString());
    }

    @Test
    public void testSearchByQuantity() {
        PurchaseList purchaseList = new PurchaseList("src\\by\\epam\\lab\\ information.txt");
        purchaseList.sortList();
        Assertions.assertEquals(6, purchaseList.searchByQuantity(3));
    }

    @Test(expected = FileNotFoundException.class)
    public void testFileNotFoundException() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("src/in1.csv"));
        sc.close();
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroValues() throws IllegalArgumentException {
        Purchase purchaseNow = PurchasesFactory.getPurchaseFromFactory("candy;0;2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeValues() throws IllegalArgumentException {
        Purchase purchaseNow = PurchasesFactory.getPurchaseFromFactory("candy;-100;-2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void noValues() throws IllegalArgumentException {
        Purchase purchaseNow = PurchasesFactory.getPurchaseFromFactory("candy");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidValues() throws IllegalArgumentException {
        Purchase purchaseNow = PurchasesFactory.getPurchaseFromFactory("candy;100;2;500");
    }

    @Test(expected = IllegalArgumentException.class)
    public void notIntegerValues() throws IllegalArgumentException {
        Purchase purchaseNow = PurchasesFactory.getPurchaseFromFactory("water;70;4;0.5");
    }

}
