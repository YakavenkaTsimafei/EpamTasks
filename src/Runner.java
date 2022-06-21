import by.epam.lab.Purchase;
import by.epam.lab.PurchasesFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Runner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("src\\in.txt"))) {
            Purchase[] purchasesFactory = new Purchase[6];
            int i = 0;
            while (sc.hasNext()) {
                purchasesFactory[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                i++;
            }
              //Arrays.sort(purchasesFactory);
            for (int j = 0; j < purchasesFactory.length; j++) {
                System.out.println(purchasesFactory[j]);
            }
//            System.out.println(purchasesFactory[3]);
//            System.out.println(purchasesFactory[4]);
            System.out.println(purchasesFactory[3].equals(purchasesFactory[4]));


        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}
