package by.epam.lab;

import java.util.Scanner;

public class PurchaseWithADiscount extends Purchase {
    private static final double DISCOUNT = 15;

    public PurchaseWithADiscount() {
    }

    public PurchaseWithADiscount(Scanner sc) {
        super(sc);
    }

    public PurchaseWithADiscount(String name, int price, int number) {
        super(name, price, number);
    }

    @Override
    public int getCost() {
        return (int) (getPrice() * getNumber() * (100 - DISCOUNT) / 100);
    }

    @Override
    public String toString() {
        return DISCOUNT + ";" + super.toString();
    }
}
