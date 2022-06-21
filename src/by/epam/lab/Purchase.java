package by.epam.lab;

import java.util.Scanner;

import static by.epam.lab.Utils.toByn;

public class Purchase {
    private String name;
    private int price;
    private int number;

    public Purchase() {

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

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCost() {
        return  price * number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
       Purchase purchase = (Purchase) o;
        return price == purchase.price && name.equals(purchase.name);
    }

    @Override
    public String toString() {
        return name + ";" + toByn(price) + ";" + number + ";" + toByn(getCost()) ;
    }
}

