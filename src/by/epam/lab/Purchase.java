package by.epam.lab;

public class Purchase implements Comparable<Purchase> {
    public static final String NAME = "Milk";
    public static final int PRICE = 300;
    private int number;
    private double percent;
    private WeekDay day;

    public Purchase() {

    }

    public Purchase(int number, double percent, WeekDay day) {
        this.number = number;
        this.percent = percent;
        this.day = day;
    }

    public Purchase(int number, double percent, int day) {
        this(number, percent, WeekDay.values()[day]);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public WeekDay getDay() {
        return day;
    }

    public void setDay(WeekDay day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return number + ";" + percent + ";" + toByn((int) Math.round(getCost() / 100) * 100) + ";" + day;
    }

    @Override
    public int compareTo(Purchase purchase) {
        return this.number - purchase.number;
    }

    public double getCost() {
        return (PRICE * number * (100 - percent) / 100);
    }

    public String toByn(int coins) {
        return String.format("%d.%02d", (coins / 100), coins % 100);
    }

}


