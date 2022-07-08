package by.epam.lab;

import java.util.Scanner;

public class PercentDiscountPurchase extends Purchase {
    private double discount;
    private static final int DISCOUNT_QUANTITY = 5;

    public PercentDiscountPurchase() {

    }

    public PercentDiscountPurchase(Scanner sc) {
        super(sc);
        this.discount = sc.nextDouble();
    }

    public PercentDiscountPurchase(String name, Byn price, int number, double discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public static int getDiscountQuantity() {
        return DISCOUNT_QUANTITY;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        Byn x;
        if (getNumber() >= DISCOUNT_QUANTITY) {
            x = getPrice().copy(getPrice()).mul((100 - discount) / 100, Method.RoundMethod.CEIL, 1).mul(getNumber());
        } else {
            x = getPrice().copy(getPrice()).mul(getNumber());
        }
        return x;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}
