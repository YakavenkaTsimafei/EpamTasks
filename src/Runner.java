import by.epam.lab.Purchase;
import by.epam.lab.WeekDay;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new FileReader("src\\in.txt"))) {

            int[] PURCHASES_NUMBER = new int[11];
            Purchase[] purchase = new Purchase[11];
            WeekDay[] weekDays = WeekDay.values();
            int amountMonday = 0;
            int g = 0;

            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] number = line.split(" ");
                for (int i = 0; i < number.length; i++) {
                    PURCHASES_NUMBER[i] = Integer.parseInt(number[i]);
                }

                purchase[g] = new Purchase(PURCHASES_NUMBER[1], PURCHASES_NUMBER[2], weekDays[PURCHASES_NUMBER[3]]);
                if (g == 0) {
                    System.out.println("Product : " + purchase[0].getName() +
                            "\nPrice = " + purchase[0].getPrice());
                }
                System.out.println(PURCHASES_NUMBER[0] + ";" + purchase[g]);
                if (PURCHASES_NUMBER[3] == 1) {
                    amountMonday += purchase[g].getCost();
                }
                g++;
            }
            int h = 0;
            int generalCost = 0;
            int totalNumber = 0;
            int minPercent = purchase[0].getPercent();
            for (int i = 0; i < purchase.length; i++) {
                generalCost += purchase[i].getCost();
                totalNumber += purchase[i].getNumber();
                if (purchase[i].getPercent() < minPercent)
                    minPercent = purchase[i].getPercent();
            }
            for (int i = 0; i < purchase.length; i++) {

                if (purchase[i].getPercent() == minPercent) {
                    h = i;
                }
            }
            double averageCost = ((double) generalCost / (double) totalNumber);
            Arrays.sort(purchase);
            System.out.println("Shopping on Monday = " + amountMonday);
            System.out.println("Maximum purchase price : " + purchase[h]);
            System.out.printf("Average cost = %.3f\n", averageCost);
            int index = Arrays.binarySearch(purchase, new Purchase(5, 3, weekDays[2]));
            System.out.println("Purchase number with 5 items: " + index);

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }

    }

}


