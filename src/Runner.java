import by.epam.lab.Purchase;
import by.epam.lab.PurchasesFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("src\\in.txt"))) {
            Purchase[] purchases = new Purchase[6];
            int i = 0;
            int c = 0;
            Purchase purchaseWithMaxCost = new Purchase();
            while (sc.hasNext()) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                if (i > 0 && purchases[i].getPrice().compareTo(purchases[i - 1].getPrice()) > 0) {
                    purchaseWithMaxCost = purchases[i - 1];
                }
                System.out.println(purchases[i]);
                if (purchases[0].equals(purchases[i])) {
                    c++;
                }
                if (c == purchases.length && i == purchases.length-1) {
                    System.out.println("All purchases are equal");
                }
                if (c != purchases.length && i == purchases.length-1) {
                    System.out.println("All purchases aren't equal");
                }
                i++;
            }
            System.out.println("Purchase with maximum Cost : " + purchaseWithMaxCost);
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}
