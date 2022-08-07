package by.epam.lab;

public class PriceDiscountPurchase extends AbstractPurchase {
    private Byn discount;

    @Override
    protected Byn getFinalCost(Byn baseCost) {
        return baseCost.sub(discount.mul(getNumber()));
    }

    public PriceDiscountPurchase() {
        this(new Product(null, new Byn(0)), 0, new Byn(0));
    }

    public PriceDiscountPurchase(Product product, int number, Byn discount) {
        super(product, number);
        this.discount = discount;
    }

    public Byn getDiscount() {
        return discount;
    }

    public void setDiscount(Byn discount) {
        this.discount = discount;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }

}
