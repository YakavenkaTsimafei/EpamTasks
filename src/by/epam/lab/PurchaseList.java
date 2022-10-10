package by.epam.lab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PurchaseList {
    private final String fileName;
    private final List<Purchase> purchaseList;

    public PurchaseList(String fileName, List<Purchase> purchaseList) {
        this.fileName = fileName;
        this.purchaseList = purchaseList;
    }

    public String getFileName() {
        return fileName;
    }

    public List<Purchase> getPurchaseList() {
        Purchase purchase;
        try (Scanner sc = new Scanner(new FileReader("src\\by\\epam\\lab\\ " + fileName))) {
            while (sc.hasNext()) {
                String line = sc.nextLine();
                Pattern pattern = Pattern.compile("[a-z]+;[1-9]+\\d*;[1-9]+\\d*;[1-9]+\\d*");
                Matcher matcher = pattern.matcher(line);
                Pattern pattern1 = Pattern.compile("[a-z]+;[1-9]+\\d*;[1-9]+\\d*\\b");
                Matcher matcher2 = pattern1.matcher(line);
                if (matcher.matches()) {
                    String[] number = line.split(";");
                    if (Integer.parseInt(number[1]) > Integer.parseInt(number[3])) {
                        purchase = new PriceDiscountPurchase(number[0], Integer.parseInt(number[1]), Integer.parseInt(number[2]), Integer.parseInt(number[3]));
                        purchaseList.add(purchase);
                    }
                } else if (matcher2.matches()) {
                    String[] number = line.split(";");
                    purchase = new Purchase(number[0], Integer.parseInt(number[1]), Integer.parseInt(number[2]));
                    purchaseList.add(purchase);
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("файл не найден");
        }

        return purchaseList;
    }

    public void dataOutput() {
        Purchase purchase;
        try (Scanner sc = new Scanner(new FileReader("src\\by\\epam\\lab\\ " + fileName))) {
            while (sc.hasNext()) {
                String line = sc.nextLine();
                Pattern pattern = Pattern.compile("[a-z]+;[1-9]+\\d*;[1-9]+\\d*;[1-9]+\\d*");
                Matcher matcher = pattern.matcher(line);
                Pattern pattern1 = Pattern.compile("[a-z]+;[1-9]+\\d*;[1-9]+\\d*\\b");
                Matcher matcher2 = pattern1.matcher(line);
                if (matcher.matches()) {
                    String[] number = line.split(";");
                    if (Integer.parseInt(number[1]) * Integer.parseInt(number[2]) > Integer.parseInt(number[3])) {
                        purchase = new PriceDiscountPurchase(number[0], Integer.parseInt(number[1]), Integer.parseInt(number[2]), Integer.parseInt(number[3]));
                        System.out.println(purchase);

                    } else {
                        System.err.println(line);
                    }
                } else if (matcher2.matches()) {
                    String[] number = line.split(";");
                    purchase = new Purchase(number[0], Integer.parseInt(number[1]), Integer.parseInt(number[2]));
                    System.out.println(purchase);
                } else {
                    System.err.println(line);
                }

            }
            System.out.println();

        } catch (FileNotFoundException e) {
            System.out.println("File not found ");
        }

    }

    public void addingANewPurchase(int index, Purchase newPurchase) {
        boolean status = true;
        while (status) {
            if (newPurchase instanceof PriceDiscountPurchase && newPurchase.getPrice() * newPurchase.getNumber() <= ((PriceDiscountPurchase) newPurchase).getDiscount()) {
                break;
            }
            purchaseList.add(Math.min(purchaseList.size(), index), newPurchase);
            status = false;
        }
    }

    public void removingFromTheGap(int indexStart, int indexEnd) {
        if (indexEnd > purchaseList.size()) {
            indexEnd = purchaseList.size();
        }
        purchaseList.subList(indexStart, indexEnd).clear();

    }

    public int totalCost() {
        int totalCost = 0;
        for (Purchase purchase : purchaseList) {
            totalCost += purchase.getCost();
        }
        return totalCost;
    }

    public List<Purchase> sortList() {

        purchaseList.sort(comparator);
        return purchaseList;
    }

    public Purchase searchByQuantity(int quantity) {
        Comparator<Purchase> comparator = new Comparator<Purchase>() {
            @Override
            public int compare(Purchase left, Purchase right) {
                return left.getNumber() - right.getNumber();
            }
        };
        int index;
        index = Collections.binarySearch(purchaseList, new PriceDiscountPurchase(null, 0, quantity, 0), comparator);
        return getPurchaseList().get(index);
    }

    @Override
    public String toString() {
        return fileName + ";" + purchaseList;
    }

    static Comparator<Purchase> comparator = new Comparator<Purchase>() {
        @Override
        public int compare(Purchase left, Purchase right) {
            return left.getNumber() - right.getNumber();
        }
    };
}
