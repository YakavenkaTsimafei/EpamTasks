package by.epam.lab;

import java.util.Scanner;

public class PurchaseWithADiscountDependingOnTheQuantity extends Purchase {
    private double discount;
    private static final int DISCOUNT_QUANTITY = 5;

    public PurchaseWithADiscountDependingOnTheQuantity() {

    }

    public PurchaseWithADiscountDependingOnTheQuantity(Scanner sc) {
        super(sc);
        this.discount = sc.nextDouble();
    }

    public PurchaseWithADiscountDependingOnTheQuantity(String name, Byn price, int number, double discount) {
        super(name, price, number);
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        if (getNumber() >= DISCOUNT_QUANTITY) {
            return getPrice().copy(getPrice()).mltpDiscount(getNumber(), discount);
        } else {
            return getPrice().copy(getPrice()).mltp(getNumber());
        }
    }

    @Override
    public String toString() {
        return super.getName() + ";" + super.getPrice() + ";" + super.getNumber() + ";" + discount + ";" + getCost();
    }
}
