package by.epam.lab;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    private final Product product;
    private int number;

    protected abstract Byn getFinalCost(Byn baseCost);


    public AbstractPurchase() {
        this(null, 0);
    }

    public AbstractPurchase(Product product, int number) {
        this.product = product;
        this.number = number;
    }

    public Product getProduct() {
        return product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        return o.getCost().compareTo(this.getCost());
    }

    public Byn getCost() {
        Byn baseCost = product.getPrice().mul(number);
        Byn finalCost = getFinalCost(baseCost);
        return finalCost.round(RoundMethod.FLOOR, 2);
    }

    protected String fieldsToString() {
        return getClass().getSimpleName() + ";" + product + ";" + number;
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }


}
