package by.epam.lab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class PurchaseList {

    private List<Purchase> purchaseList = new ArrayList<>();

    public PurchaseList() {
    }


    public PurchaseList(String fileName) {
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            while (sc.hasNextLine()) {
                Purchase purchaseNow;
                String line = sc.nextLine();
                try {
                    purchaseNow = PurchasesFactory.getPurchaseFromFactory(line);
                    purchaseList.add(purchaseNow);
                } catch (IllegalArgumentException e) {
                    System.err.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(Constants.FILE_NOT_FOUND);
        }
    }

    public List<Purchase> getPurchaseList() {
        return List.copyOf(purchaseList);
    }

    public void addingANewPurchase(int index, Purchase newPurchase) {
        if (index >= purchaseList.size()) {
            purchaseList.add(newPurchase);
        } else purchaseList.add(Math.max(index, 0), newPurchase);
    }

    public void removingFromTheGap(int indexStart, int indexEnd) {
        if (indexEnd >= purchaseList.size()) {
            indexEnd = purchaseList.size();
        }
        if (indexStart < 0) {
            indexStart = 0;
        }
        purchaseList.subList(indexStart, indexEnd).clear();

    }

    public Byn totalCost() {
        Byn byn = new Byn();
        for (Purchase purchase : purchaseList) {
            byn = byn.add(purchase.getCost());
        }
        return byn;
    }

    public void sortList() {
        purchaseList.sort(comparator);

    }

    public int searchByQuantity(int quantity) {
        return Collections.binarySearch(purchaseList, new Purchase(null, new Byn(), quantity), comparator);
    }


    static Comparator<Purchase> comparator = new Comparator<Purchase>() {
        @Override
        public int compare(Purchase left, Purchase right) {
            return left.getNumber() - right.getNumber();
        }
    };
}
