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
                if (i == 0) {
                    purchaseWithMaxCost = purchases[0];
                }
                if (i > 0 && purchases[i].getCost().compareTo(purchaseWithMaxCost.getCost()) < 0) {
                    purchaseWithMaxCost = purchases[i];
                }
                System.out.println(purchases[i]);
                if (purchases[0].equals(purchases[i])) {
                    c++;
                }

                i++;
            }
            if (c == purchases.length) {
                System.out.println("All purchases are equal");
            } else {
                System.out.println("All purchases aren't equal");
            }
            System.out.println("Purchase with maximum Cost : " + purchaseWithMaxCost);

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}
