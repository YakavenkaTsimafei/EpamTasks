package by.epam.lab;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {
    private final int discount;
    private static final String SEPARATOR = ";";

    public PriceDiscountPurchase() {
        this(null, 0, 0, 0);
    }

    public PriceDiscountPurchase(Scanner sc) {
        super(sc);
        this.discount = sc.nextInt();
    }

    public PriceDiscountPurchase(String name, int price, int number, int discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public int getCost() {
        return getPrice() * getNumber() - discount;
    }

    @Override
    public String toString() {
        return fieldsToString() + SEPARATOR + discount + SEPARATOR + getCost();
    }
}
