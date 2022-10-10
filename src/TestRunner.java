import by.epam.lab.PriceDiscountPurchase;
import by.epam.lab.Purchase;
import by.epam.lab.PurchaseList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    @Test
    public void testAddingANewPurchase() {
        List<Purchase> list = new ArrayList<>();
        PurchaseList purchaseList = new PurchaseList("information.txt", list);
        purchaseList.dataOutput();
        System.out.println(purchaseList.getPurchaseList());
        List<Purchase> listToCheck = new ArrayList<>(list);
        Purchase purchaseToAdd = new Purchase("water", 50, 5);
        Purchase purchaseToAdd1 = new PriceDiscountPurchase("cheese", 20, 3, 10);
        Purchase purchaseToAdd2 = new PriceDiscountPurchase("tomatoes", 50, 2, 100);
        listToCheck.add(1, purchaseToAdd);
        purchaseList.addingANewPurchase(1, purchaseToAdd);
        listToCheck.add(9, purchaseToAdd1);
        purchaseList.addingANewPurchase(99, purchaseToAdd1);
        purchaseList.addingANewPurchase(2, purchaseToAdd2);
        Assertions.assertEquals(listToCheck, list);
    }

    @Test
    public void testRemovingFromTheGap() {
        List<Purchase> list = new ArrayList<>();
        List<Purchase> listToCheck = new ArrayList<>();
        PurchaseList purchaseList = new PurchaseList("information.txt", list);
        PurchaseList purchaseList1 = new PurchaseList("information.txt", listToCheck);
        purchaseList.dataOutput();
        purchaseList.getPurchaseList();
        purchaseList1.getPurchaseList();
        purchaseList.removingFromTheGap(1, 6);
        purchaseList1.removingFromTheGap(3, 99);
        Assertions.assertEquals(list.toString(), "[bread;155;1;2;153, butter;341;1;1;340, meat;1100;2;80;2120]");
        Assertions.assertEquals(listToCheck.toString(), "[bread;155;1;2;153, milk;131;2;262, bread;154;3;462]");

    }

    @Test
    public void testTotalCoast() {
        List<Purchase> list = new ArrayList<>();
        PurchaseList purchaseList = new PurchaseList("information.txt", list);
        purchaseList.dataOutput();
        System.out.println(purchaseList.getPurchaseList());
        Assertions.assertEquals(purchaseList.totalCost(), 4782);

    }

    @Test
    public void testSortList() {
        List<Purchase> list = new ArrayList<>();
        PurchaseList purchaseList = new PurchaseList("information.txt", list);
        purchaseList.dataOutput();
        System.out.println(purchaseList.getPurchaseList());
        Assertions.assertEquals(purchaseList.sortList().toString(), "[bread;155;1;2;153, butter;370;1;370, butter;341;1;1;340, milk;131;2;262, potato;180;2;10;350, meat;1100;2;80;2120, bread;154;3;462, bread;145;5;725]");

    }

    @Test
    public void testSearchByQuantity() {
        List<Purchase> list = new ArrayList<>();
        PurchaseList purchaseList = new PurchaseList("information.txt", list);
        purchaseList.dataOutput();
        System.out.println(purchaseList.getPurchaseList());
        Purchase purchaseForCheck = new Purchase("bread", 154, 3);
        Assertions.assertEquals(purchaseList.searchByQuantity(3).toString(), purchaseForCheck.toString());

    }


}
