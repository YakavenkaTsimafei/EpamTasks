package by.epam.lab;

import java.util.Scanner;

public class PurchaseWithADiscountDependingOnTheQuantity extends Purchase {
    private static final double DISCOUNT = 10;
    private static final int DISCOUNT_QUANTITY = 5;

    public PurchaseWithADiscountDependingOnTheQuantity() {
    }

    public PurchaseWithADiscountDependingOnTheQuantity(Scanner sc) {
        super(sc);
    }

    public PurchaseWithADiscountDependingOnTheQuantity(String name, int price, int number) {
        super(name, price, number);
    }

    @Override
    public int getCost() {
        if (getNumber() >= DISCOUNT_QUANTITY) {
            return (int) (getPrice() * getNumber() * (100 - DISCOUNT)/100);
        } else {
            return (int) getPrice() * getNumber();
        }
    }

    @Override
    public String toString() {
        return DISCOUNT + ";" + super.toString();
    }
}
