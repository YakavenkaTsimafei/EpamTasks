package by.epam.lab.bean;

import static by.epam.lab.Constant.SEPARATOR;

public class DiscountProduct extends Product {
    private final Byn discount;

    public DiscountProduct() {
        this.discount = new Byn();
    }

    public DiscountProduct(String productName, Byn cost, Byn price) {
        super(productName, cost);
        this.discount = price;
    }

    public Byn getDiscount() {
        return discount;
    }

    @Override
    public Byn getPrice() {
        return super.getPrice().sub(discount);
    }

    @Override
    public String toString() {
        return super.toString() + SEPARATOR + discount;
    }
}