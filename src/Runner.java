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
            WeekDay[] weekDays = WeekDay.values();
            int amountMonday = 0;
            int g = 0;
            sc.nextLine();
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] number = line.split(" ");
                for (int i = 0; i < number.length; i++) {
                    arrayForInitialize[i] = Integer.parseInt(number[i]);
                }
                purchase[g] = new Purchase(arrayForInitialize[0], arrayForInitialize[1], weekDays[arrayForInitialize[2]]);
                g++;
            }
            int h = 0;
            int generalCost = 0;
            int maxCost = purchase[0].getCost();
            System.out.println("Product : " + purchase[0].getName() + "\nPrice = " + purchase[0].getPrice());
            for (int i = 0; i < purchase.length; i++) {
                System.out.println(purchase[i]);
                generalCost += purchase[i].getCost();
                if (purchase[i].getWeekDay() == WeekDay.MONDAY) {
                    amountMonday += purchase[i].getCost();
                }
                if (purchase[i].getCost() > maxCost) {
                    maxCost = purchase[i].getCost();
                    h = i;
                }
            }
            double averageCost = ((double) generalCost / PURCHASES_NUMBER);
            System.out.printf("Shopping on Monday = %d.00\n", amountMonday / 100);
            System.out.println("Day with max purchase : " + purchase[h].getWeekDay());
            System.out.printf("Average cost =%.3f\n", averageCost / 100);
            Arrays.sort(purchase);
            int index = Arrays.binarySearch(purchase, new Purchase(5, 0, null));
            System.out.println("Purchase with 5 items: " + purchase[index]);
            for (Purchase p : purchase) {
                System.out.println(p);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }

    }

}


