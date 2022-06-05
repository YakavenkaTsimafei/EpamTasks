package by.epam.lab;

public class ToByn {
    public static String toByn(int coins) {
        return String.format("%d.%02d", (coins / 100), coins % 100);
    }
}
