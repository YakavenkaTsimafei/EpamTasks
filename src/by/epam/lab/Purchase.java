package by.epam.lab;

public class Purchase implements Comparable<Purchase> {
    private static final String NAME = "Milk";
    private static final int PRICE = 300;
    private int number;
    private int percent;
    private WeekDay weekDay;

    public Purchase() {

    }

    public Purchase(int number, int percent, WeekDay weekDay) {
        this.number = number;
        this.percent = percent;
        this.weekDay = weekDay;
    }

    public String getName() {
        return NAME;
    }

    public int getPrice() {
        return PRICE;
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
        return number + ";" + percent + ";" + toByn((int) (Math.floor(getCost() / 100)) * 100) + ";" + weekDay;
    }

    @Override
    public int compareTo(Purchase purchase) {
        return this.number - purchase.number;
    }

    public int getCost() {
        return ((PRICE * number * (100 - percent) / 100));
    }

    public String toByn(int coins) {
        return String.format("%d.%02d", (coins / 100), coins % 100);
    }

}


