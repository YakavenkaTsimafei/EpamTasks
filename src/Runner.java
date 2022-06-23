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
            int purchaseNumberWithMaxCost = 0;
            int purchaseWithMaximumCost = 0;
            while (sc.hasNext()) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                if (purchases[i].getCost() > purchaseWithMaximumCost) {
                    purchaseWithMaximumCost = purchases[i].getCost();
                    System.out.println(purchases[i]);
                }
                System.out.println(purchases[i]);
                if (i > 0) {
                    System.out.println(purchases[i].equals(purchases[i - 1]));
                }
                if (purchases[i].getCost() == purchaseWithMaximumCost) {
                    purchaseNumberWithMaxCost = i;
                }
                i++;
            }

            System.out.println("Purchase with maximum Cost : " + purchases[purchaseNumberWithMaxCost]);
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}
