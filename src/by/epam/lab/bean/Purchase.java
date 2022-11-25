package by.epam.lab.bean;

import by.epam.lab.RoundMethod;
import by.epam.lab.Sale;

import static by.epam.lab.Constant.SEPARATOR;

public class Purchase {
    private Sale product;
    private Number quantity;

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

    public void setProduct(Sale product) {
        this.product = product;
    }

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Byn getCost() {
        return product.getPrice().mul(quantity.doubleValue(), RoundMethod.FLOOR, 0);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + SEPARATOR + product + SEPARATOR + quantity + SEPARATOR + getCost();
    }
}
