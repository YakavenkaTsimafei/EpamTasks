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

    public String getProductName() {
        return productName;
    }

    @Override
    public Byn getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return productName + SEPARATOR + price;

    }
}
