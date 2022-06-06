import by.epam.lab.Purchase;
import by.epam.lab.Utils;
import by.epam.lab.WeekDay;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("src\\in.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            final int PURCHASES_NUMBER = sc.nextInt();
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];
            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                purchases[i] = new Purchase(sc.nextInt(), sc.nextDouble(), sc.nextInt());
            }
            dataOutput(purchases);
            WeekDay maxCostWeekDay = null;
            int generalCost = 0;
            int maxCost = 0;
            int amountMonday = 0;
            double averageCost = 0;
            for (Purchase p : purchases) {
                int cost = p.getCost();
                generalCost += cost;
                if (p.getDay() == WeekDay.MONDAY) {
                    amountMonday += cost;
                }
                if (cost > maxCost) {
                    maxCost = cost;
                    maxCostWeekDay = p.getDay();
                }
            }
            if (purchases.length > 0) {
                averageCost = (double) generalCost / purchases.length;
            }
            System.out.printf("Shopping on Monday = %s\n", Utils.toByn(amountMonday));
            System.out.println("Day with max purchases : " + maxCostWeekDay);
            System.out.printf("Average cost =%.3f\n", averageCost / 100);
            Arrays.sort(purchases);
            int index = Arrays.binarySearch(purchases, new Purchase(5, 0, null));
            if (index >= 0) {
                System.out.println("Purchase with 5 items: " + purchases[index]);
            } else {
                System.out.println("The desired element is not in the array");
            }
            dataOutput(purchases);

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }

    }

    private static void dataOutput(Purchase[] purchase) {
        System.out.println("Product : " + Purchase.NAME + "\nPrice = " + Utils.toByn(Purchase.PRICE));
        for (Purchase p : purchase) {
            System.out.println(p);

        }
    }
}




