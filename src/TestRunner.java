import by.epam.lab.WeekDay;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


class PurchaseTest {
    private final String name = "Milk";
    private final double price = 2.55;
    private int number;
    private int percent;
    private WeekDay weekDay;

    public PurchaseTest() {

    }

    public PurchaseTest(int number, int percent, WeekDay weekDay) {
        this.number = number;
        this.percent = percent;
        this.weekDay = weekDay;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    @Override
    public String toString() {
        return String.format("%d;%d;%.3f;%s", number, percent, getCost(), weekDay);
    }


    public double getCost() {
        return price * number * (100 - percent) / 100;
    }
}

public class TestRunner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("C:\\Users\\timmy\\IdeaProjects\\EpamTasks\\src\\in.txt"))) {

            int[] PURCHASES_NUMBER = new int[11];
            PurchaseTest[] purchase = new PurchaseTest[11];
            WeekDay[] weekDays = WeekDay.values();
            int g = 0;
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] number = line.split(" ");
                for (int i = 0; i < number.length; i++) {
                    PURCHASES_NUMBER[i] = Integer.parseInt(number[i]);
                }
                purchase[g] = new PurchaseTest(PURCHASES_NUMBER[1], PURCHASES_NUMBER[2], weekDays[PURCHASES_NUMBER[3]]);
                System.out.println(PURCHASES_NUMBER[0] + ";" + purchase[g]);
                g++;
            }

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}



