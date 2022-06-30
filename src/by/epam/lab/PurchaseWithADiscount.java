package by.epam.lab;

import java.util.Scanner;

public class PurchaseWithADiscount extends Purchase {
    private Byn discount;

    public PurchaseWithADiscount(Purchase purchase, Byn byn1) {

    }

    public PurchaseWithADiscount(Scanner sc) {
        super(sc);
        this.discount = new Byn(sc.nextInt());
    }

    public PurchaseWithADiscount(String name, Byn price, int number, Byn discount) {
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
        return getPrice().copy(getPrice()).difference(discount, getNumber());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ";" + getName() + ";" + getPrice() + ";" + getNumber() + ";" + discount + ";" + getCost();
    }
}
