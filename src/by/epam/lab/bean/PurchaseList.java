package by.epam.lab.bean;

import by.epam.lab.PurchasesFactory;
import by.epam.lab.exception.CsvLineException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import static by.epam.lab.Constants.*;


public class PurchaseList {

    private final List<Purchase> purchaseList = new ArrayList<>();

    public PurchaseList(String fileName) {

        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            while (sc.hasNextLine()) {
                try {
                    purchaseList.add(PurchasesFactory.getPurchase(sc.nextLine()));
                } catch (CsvLineException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(FILE_NOT_FOUND);
        }
    }

    public List<Purchase> getPurchaseList() {
        return List.copyOf(purchaseList);
    }

    public void addingANewPurchase(int index, Purchase newPurchase) {
        if (index >= purchaseList.size()) {
            purchaseList.add(newPurchase);
        } else purchaseList.add(Math.max(index, VALUE_ZERO), newPurchase);
    }

    public void removingFromTheGap(int indexStart, int indexEnd) {
        if (indexEnd >= purchaseList.size()) {
            indexEnd = purchaseList.size();
        }
        if (indexStart < VALUE_ZERO) {
            indexStart = VALUE_ZERO;
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

    public int searchByQuantity(Purchase quantity) {
        return Collections.binarySearch(purchaseList,quantity, comparator);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Purchase purchase : purchaseList) {
            result.append(purchase).append(SEPARATOR);
        }
        if (!purchaseList.isEmpty()) {
            result.delete(result.length() - SEPARATOR.length(), result.length());
        }
        return result.toString();
    }

    static Comparator<Purchase> comparator = new Comparator<Purchase>() {
        @Override
        public int compare(Purchase left, Purchase right) {
            return left.getNumber() - right.getNumber();
        }
    };
}
