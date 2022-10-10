package by.epam.lab;

import java.util.Scanner;

public class Purchase {
    private static final String SEPARATOR = ";";
    private final String name;
    private final int price;
    private final int number;

    public Purchase() {
        this(null, 0, 0);
    }

    public Purchase(Scanner sc) {
        this.name = sc.next();
        this.price = sc.nextInt();
        this.number = sc.nextInt();
    }

    public Purchase(String name, int price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
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

    public int getCost() {
        return price * number;
    }

    protected String fieldsToString() {
        return name + SEPARATOR + price + SEPARATOR + number;
    }

    @Override
    public String toString() {
        return fieldsToString() + SEPARATOR + getCost();
    }
}
