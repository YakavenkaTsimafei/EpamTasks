package by.epam.lab;

import java.util.Scanner;

public class PercentDiscountPurchase extends Purchase {
    private double discount;
    private static final int DISCOUNT_QUANTITY = 5;

    public PercentDiscountPurchase() {
        this("", new Byn(0), 0,0.00);
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

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        Byn x = super.getCost();
        if (getNumber() >= DISCOUNT_QUANTITY) {
            x.mul((100 - discount) / 100, Byn.RoundMethod.CEIL, 1);
        }
        return x;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}
