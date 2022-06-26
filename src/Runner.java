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
            Purchase purchaseWithMaxCost = new Purchase();


            while (sc.hasNext()) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                if (i > 0 && purchases[i].getPrice().compareTo(purchases[i - 1].getPrice()) == 1) {
                    purchaseWithMaxCost = purchases[i - 1];
                }
                System.out.println(purchases[i]);
                if (i > 0) {
                    System.out.println(purchases[i].equals(purchases[i - 1]));
                }
                i++;
            }
            System.out.println("Purchase with maximum Cost : " + purchaseWithMaxCost);
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}
