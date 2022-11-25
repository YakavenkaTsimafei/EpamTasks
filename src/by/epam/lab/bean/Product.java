package by.epam.lab.bean;

import by.epam.lab.Sale;

import static by.epam.lab.Constant.SEPARATOR;

public class Product implements Sale {
    private final String productName;
    private final Byn price;

    public Product() {
        this(null, new Byn(0));
    }

    public Product(String productName, Byn cost) {
        this.productName = productName;
        this.price = cost;
    }

    @Override
    public Byn getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    protected String fieldsToString() {
        return productName + SEPARATOR + price;
    }

    @Override
    public String toString() {
        return fieldsToString() + SEPARATOR + price;
    }
}
