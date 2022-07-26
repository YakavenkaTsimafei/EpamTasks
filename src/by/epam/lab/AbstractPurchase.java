package by.epam.lab;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    private Product product;
    private int number;

    public AbstractPurchase() {
    }

    public AbstractPurchase(Product product, int number) {
        this.product = product;
        this.number = number;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        return o.getCost().sb(this.getCost());
    }

    public Byn getCost() {
        return getProduct().getPrice().mul(number);
    }

    protected String fieldsToString() {
        return getClass().getSimpleName() + ";" + product + ";" + number;
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }


}
