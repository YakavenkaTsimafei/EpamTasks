package by.epam.lab;

import java.util.Scanner;


public class Purchase {
    private String name;
    private Byn price;
    private int number;

    public Purchase() {

    }

    public Purchase(Scanner sc) {
        this.name = sc.next();
        this.price = new Byn(sc.nextInt());
        this.number = sc.nextInt();
    }

    public Purchase(String name, Byn price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byn getPrice() {
        return price;
    }

    public void setPrice(Byn price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Byn getCost() {
        return price.copy(price).mul(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Purchase) {
            Purchase purchase = (Purchase) o;
            return name.equals(purchase.name) && price.equals(purchase.price);
        } else return false;
    }

    protected String fieldsToString() {
        return getClass().getSimpleName() + ";" + name + ";" + price + ";" + number;
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }
}
