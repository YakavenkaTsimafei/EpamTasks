package by.epam.lab;

import java.util.Scanner;

public class PurchaseWithADiscount extends Purchase {
    private int discount;

    public PurchaseWithADiscount() {

    }

    public PurchaseWithADiscount(Scanner sc) {
        super(sc);
        this.discount = sc.nextInt();
    }

    public PurchaseWithADiscount(String name, int price, int number, int discount) {
        super(name, price, number);
        this.discount = discount;
    }

    @Override
    public int getCost() {
        return (int) (getPrice() - discount) * getNumber();
    }

    @Override
    public String toString() {
        return discount + ";" + super.toString();
    }
}
