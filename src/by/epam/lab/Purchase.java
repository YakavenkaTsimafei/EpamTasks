package by.epam.lab;

public class Purchase implements Comparable<Purchase> {
    private final String name = "Milk";
    private final int price = 3;
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
        return name;
    }

    public int getPrice() {
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
        return number + ";" + percent + ";" + getCost() + ";" + weekDay;
    }

    @Override
    public int compareTo(Purchase purchase) {
        if (number < purchase.number) return 1;
        else if (number > purchase.number) return -1;
        else return 0;
    }

    public int getCost() {
        return price * number * (100 - percent) / 100;
    }
}


