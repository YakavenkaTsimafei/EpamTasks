import by.epam.lab.Purchase;
import by.epam.lab.WeekDay;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("src\\in.txt"))) {
            final int PURCHASES_NUMBER = sc.nextInt();
            Purchase[] purchase = new Purchase[PURCHASES_NUMBER];
            int[] arrayForInitialize = new int[3];
            int amountMonday = 0;
            int g = 0;
            if (PURCHASES_NUMBER != 0)
                sc.nextLine();
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] number = line.split(" ");
                for (int i = 0; i < number.length; i++) {
                    arrayForInitialize[i] = Integer.parseInt(number[i]);
                }
                purchase[g] = new Purchase(arrayForInitialize[0], arrayForInitialize[1], arrayForInitialize[2]);
                g++;
            }
            WeekDay WeekDayMaxCostDay = null;
            int generalCost = 0;
            int maxCost = 0;
            double averageCost = 0;
            System.out.println("Product : " + Purchase.NAME + "\nPrice = " + Purchase.PRICE);
            for (Purchase p : purchase) {
                System.out.println(p);
                int cost = (int) p.getCost();
                generalCost += cost;
                if (p.getDay() == WeekDay.MONDAY) {
                    amountMonday += Math.floor(cost / 100) * 100;
                }
                if (cost > maxCost) {
                    maxCost = cost;
                    WeekDayMaxCostDay = p.getDay();
                }
            }
            if (purchase.length > 0) {
                averageCost = ((double) generalCost / purchase.length);
            }
            System.out.printf("Shopping on Monday = %d.00\n", amountMonday / 100);
            System.out.println("Day with max purchase : " + WeekDayMaxCostDay);
            System.out.printf("Average cost =%.3f\n", averageCost / 100);
            Arrays.sort(purchase);
            int index = Arrays.binarySearch(purchase, new Purchase(5, 0, null));
            if (index == 1) System.out.println("Purchase with 5 items: " + purchase[index]);
            else System.out.println("The desired element is not in the array");
            for (Purchase p : purchase) {
                System.out.println(p);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }

    }

}


