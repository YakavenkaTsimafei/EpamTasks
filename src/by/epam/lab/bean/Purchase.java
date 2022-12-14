package by.epam.lab.bean;

import by.epam.lab.RoundMethod;
import by.epam.lab.Sale;

import static by.epam.lab.Constant.SEPARATOR;

public class Purchase<T extends Sale, N extends Number> {
    private final Sale product;
    private final Number quantity;

    public Purchase() {
        this(null, 0.0);
    }

    public Purchase(Sale product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Sale getProduct() {
        return product;
    }

    public Number getQuantity() {
        return quantity;
    }

    public Byn getCost() {
        return product.getPrice().mul(quantity.doubleValue(), RoundMethod.FLOOR, 0);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + SEPARATOR + product + SEPARATOR + quantity + SEPARATOR;
    }
}
