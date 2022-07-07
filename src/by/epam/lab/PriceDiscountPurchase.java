package by.epam.lab;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {
    private Byn discount;

    public PriceDiscountPurchase(Purchase purchase, Byn byn1) {

    }

    public PriceDiscountPurchase(Scanner sc) {
        super(sc);
        this.discount = new Byn(sc.nextInt());
    }

    public PriceDiscountPurchase(String name, Byn price, int number, Byn discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public Byn getDiscount() {
        return discount;
    }

    public void setDiscount(Byn discount) {
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        return getPrice().copy(getPrice()).sub(discount).mul(getNumber());
    }

    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }

}
