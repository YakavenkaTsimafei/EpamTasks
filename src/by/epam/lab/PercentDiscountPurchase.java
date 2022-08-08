package by.epam.lab;

public class PercentDiscountPurchase extends AbstractPurchase {
    private double discount;
    private static final int DISCOUNT_QUANTITY = 5;

    @Override
    protected Byn getFinalCost(Byn baseCost) {
        if (getNumber() > DISCOUNT_QUANTITY) {
            baseCost = baseCost.mul((100 - discount) / 100, RoundMethod.FLOOR, 2);
        }
        return baseCost;
    }

    public PercentDiscountPurchase() {
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
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }

}

