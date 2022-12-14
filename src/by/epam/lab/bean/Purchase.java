package by.epam.lab.bean;

import by.epam.lab.RoundMethod;
import by.epam.lab.Sale;

import static by.epam.lab.Constant.SEPARATOR;

public class Purchase<T extends Sale, N extends Number> {
    private final T product;
    private final N quantity;

    public Purchase() {
        this(null, null);
    }

    public Purchase(T product, N quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public T getProduct() {
        return product;
    }

    public N getQuantity() {
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
