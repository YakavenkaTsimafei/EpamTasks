import by.epam.lab.Purchase;
import by.epam.lab.PurchasesFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("src\\in.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            final int PURCHASES_NUMBER = 6;
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];
            boolean areEqual=true;
            Purchase purchaseWithMaxCost = new Purchase();
            for(int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                if (i == 0) {
                    purchaseWithMaxCost = purchases[0];
                }
                if (i > 0 && purchases[i].getCost().compareTo(purchaseWithMaxCost.getCost()) < 0) {
                    purchaseWithMaxCost = purchases[i];
                }
                System.out.println(purchases[i]);
                if (areEqual) {
                    areEqual=purchases[i].equals(purchases[0]);
                }
            }
            if (areEqual ==true) {
                System.out.println("All purchases are equal");
            } else {
                System.out.println("All purchases aren't equal");
            }
            System.out.println("Purchase with maximum Cost : " + purchaseWithMaxCost.toString());

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}
