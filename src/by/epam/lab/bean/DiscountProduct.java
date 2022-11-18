package by.epam.lab.bean;

import static by.epam.lab.Constant.SEPARATOR;

public class DiscountProduct extends Product {
    private Byn discount;

    public DiscountProduct(String productName, Byn cost, Byn price) {
        super(productName, cost);
        this.discount = price;
    }

    public Byn getDiscount() {
        return discount;
    }

    public void setDiscount(Byn discount) {
        this.discount = discount;
    }

    @Override
    public Byn getPrice() {
        return super.getPrice().sub(discount);
    }

    @Override
    public String toString() {
        return getProductName() + SEPARATOR + super.getPrice() + SEPARATOR + discount;
    }
}