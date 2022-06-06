package by.epam.lab;

public class Utils {
    public static String toByn(int coins) {
        return String.format("%d.%02d", coins / 100, coins % 100);
    }
}
