package by.epam.lab;

public class PercentDiscountPurchase extends AbstractPurchase {
    private double discount;
    private static final int DISCOUNT_QUANTITY = 5;

    public PercentDiscountPurchase() {
        this(new Product(null, new Byn(0)), 0, 0.00);
    }

    public PercentDiscountPurchase(Product product, int number, double discount) {
        super(product, number);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        Byn x = super.getCost();
        if (getNumber() > DISCOUNT_QUANTITY) {
            x = x.mul((100 - discount) / 100, RoundMethod.FLOOR, 2);
        }
        return x;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }

}

