import by.epam.lab.PurchasesFactory;
import by.epam.lab.bean.Byn;
import by.epam.lab.bean.Purchase;
import by.epam.lab.bean.PurchaseList;
import by.epam.lab.exception.CsvLineException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TestRunner {
    @Test
    public void testAddingANewPurchase() throws CsvLineException {
        PurchaseList purchaseList = new PurchaseList("C:\\Users\\timmy\\IdeaProjects\\EpamTasks\\src\\information.txt");
        purchaseList.addingANewPurchase(12, new Purchase("bread", new Byn(60), 6));
        purchaseList.addingANewPurchase(5, new Purchase("cheese", new Byn(50), 2));
        purchaseList.addingANewPurchase(-2, new Purchase("water", new Byn(60), 6));
        Assertions.assertEquals("water;0.60;6;3.60", purchaseList.getPurchaseList().get(0).toString());
        Assertions.assertEquals("cheese;0.50;2;1.00", purchaseList.getPurchaseList().get(6).toString());
        Assertions.assertEquals("bread;0.60;6;3.60", purchaseList.getPurchaseList().get(10).toString());

    }

    @Test
    public void testRemovingFromTheGap() {
        PurchaseList purchaseList = new PurchaseList("C:\\Users\\timmy\\IdeaProjects\\EpamTasks\\src\\information.txt");
        purchaseList.removingFromTheGap(-1, 2);
        purchaseList.removingFromTheGap(1, 99);
        Assertions.assertEquals("bread;1.54;3;4.62", purchaseList.getPurchaseList().get(0).toString());
    }

    @Test
    public void testTotalCoast() {
        PurchaseList purchaseList = new PurchaseList("C:\\Users\\timmy\\IdeaProjects\\EpamTasks\\src\\information.txt");
       Assertions.assertEquals(4692, purchaseList.totalCost().getValue());
    }

    @Test
    public void testSortList() {
        PurchaseList purchaseList = new PurchaseList("C:\\Users\\timmy\\IdeaProjects\\EpamTasks\\src\\information.txt");
        System.out.println(purchaseList.getPurchaseList());
        purchaseList.sortList();
        System.out.println(purchaseList.getPurchaseList());
        Assertions.assertEquals("bread;1.55;1;0.02;1.53", purchaseList.getPurchaseList().get(0).toString());
        Assertions.assertEquals("bread;1.45;5;7.25", purchaseList.getPurchaseList().get(7).toString());
    }

    @Test
    public void testBynStrKops() {
        Byn byn = new Byn("400");
        Byn byn1 = new Byn(400);
        Assertions.assertEquals(byn, byn1);

    }

    @Test
    public void testSearchByQuantity() {
        PurchaseList purchaseList = new PurchaseList("C:\\Users\\timmy\\IdeaProjects\\EpamTasks\\src\\information.txt");
        purchaseList.sortList();
        System.out.println(purchaseList.getPurchaseList());
        Assertions.assertEquals(6, purchaseList.searchByQuantity(new Purchase("1",new Byn(1),3)));
    }

    @Test(expected = FileNotFoundException.class)
    public void testFileNotFoundException() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("src\\by\\epam\\lab\\information2.txt"));
        sc.close();
    }

    @Test(expected = CsvLineException.class)
    public void zeroValues() throws CsvLineException {
        Purchase purchaseNow = PurchasesFactory.getPurchase("candy;0;2");
    }

    @Test(expected = CsvLineException.class)
    public void negativeValues() throws CsvLineException {
        Purchase purchaseNow = PurchasesFactory.getPurchase("candy;-100;-2");
    }

    @Test(expected = CsvLineException.class)
    public void noValues() throws CsvLineException {
        Purchase purchaseNow = PurchasesFactory.getPurchase("candy");
    }

    @Test(expected = CsvLineException.class)
    public void invalidValues() throws CsvLineException {
        Purchase purchaseNow = PurchasesFactory.getPurchase("candy;100;2;500");
    }

    @Test(expected = CsvLineException.class)
    public void notIntegerValues() throws CsvLineException {
        Purchase purchaseNow = PurchasesFactory.getPurchase("water;70;4;0.5");
    }

}
