import by.epam.lab.PurchasesFactory;
import by.epam.lab.bean.Byn;
import by.epam.lab.bean.Purchase;
import by.epam.lab.bean.PurchaseList;
import by.epam.lab.exception.CsvLineException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Scanner;

public class TestRunner {
    static Comparator<Purchase> comparator = new Comparator<Purchase>() {
        @Override
        public int compare(Purchase left, Purchase right) {
            return left.getCost().compareTo(right.getCost());
        }
    };

    @Test
    public void testAddingANewPurchase() throws CsvLineException {
        PurchaseList purchaseList = new PurchaseList("C:\\Users\\timmy\\IdeaProjects\\EpamTasks\\src\\information.txt", comparator);
        Assertions.assertNotEquals("[water;0.60;6;3.60, bread;1.55;1;0.02;1.53, milk;1.31;2;2.62, bread;1.54;3;4.62, bread;1.45;5;7.25, potato;1.80;2;0.10;3.40, cheese;0.50;2;1.00, butter;3.70;1;3.70, butter;3.41;1;0.01;3.40, meat;11.00;2;0.80;20.40, bread;0.60;6;3.60]", purchaseList.getPurchaseList().toString());
        purchaseList.addingANewPurchase(12, new Purchase("bread", new Byn(60), 6));
        purchaseList.addingANewPurchase(5, new Purchase("cheese", new Byn(50), 2));
        purchaseList.addingANewPurchase(-2, new Purchase("water", new Byn(60), 6));
        System.out.println(purchaseList.getPurchaseList());
        Assertions.assertEquals("[water;0.60;6;3.60, bread;1.55;1;0.02;1.53, milk;1.31;2;2.62, bread;1.54;3;4.62, bread;1.45;5;7.25, potato;1.80;2;0.10;3.40, cheese;0.50;2;1.00, butter;3.70;1;3.70, butter;3.41;1;0.01;3.40, meat;11.00;2;0.80;20.40, bread;0.60;6;3.60]", purchaseList.getPurchaseList().toString());
    }

    @Test
    public void testRemovingFromTheGap() {
        PurchaseList purchaseList = new PurchaseList("C:\\Users\\timmy\\IdeaProjects\\EpamTasks\\src\\information.txt", comparator);
        Assertions.assertNotEquals("bread;1.54;3;4.62", purchaseList.getPurchaseList().toString());
        purchaseList.removingFromTheGap(-1, 2);
        purchaseList.removingFromTheGap(1, 99);
        Assertions.assertEquals("[bread;1.54;3;4.62]", purchaseList.getPurchaseList().toString());
    }

    @Test
    public void testTotalCoast() {
        PurchaseList purchaseList = new PurchaseList("C:\\Users\\timmy\\IdeaProjects\\EpamTasks\\src\\information.txt", comparator);
        Assertions.assertEquals("46.92", purchaseList.totalCost().toString());
    }

    @Test
    public void testSortList() {
        PurchaseList purchaseList = new PurchaseList("C:\\Users\\timmy\\IdeaProjects\\EpamTasks\\src\\information.txt", comparator);
        Assertions.assertNotEquals("[bread;1.55;1;0.02;1.53, milk;1.31;2;2.62, potato;1.80;2;0.10;3.40, butter;3.41;1;0.01;3.40, butter;3.70;1;3.70, bread;1.54;3;4.62, bread;1.45;5;7.25, meat;11.00;2;0.80;20.40]", purchaseList.getPurchaseList().toString());
        purchaseList.sortList();
        Assertions.assertEquals("[bread;1.55;1;0.02;1.53, milk;1.31;2;2.62, potato;1.80;2;0.10;3.40, butter;3.41;1;0.01;3.40, butter;3.70;1;3.70, bread;1.54;3;4.62, bread;1.45;5;7.25, meat;11.00;2;0.80;20.40]", purchaseList.getPurchaseList().toString());

    }

    @Test
    public void testBynStrKops() {
        Byn byn = new Byn("400");
        Byn byn1 = new Byn(400);
        Assertions.assertEquals(byn, byn1);

    }

    @Test
    public void testSearchByQuantity() {
        PurchaseList purchaseList = new PurchaseList("C:\\Users\\timmy\\IdeaProjects\\EpamTasks\\src\\information.txt", comparator);
        purchaseList.sortList();
        System.out.println(purchaseList.getPurchaseList());
        Assertions.assertEquals(4, purchaseList.searchByQuantity(new Purchase("1", new Byn(370), 1)));
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
