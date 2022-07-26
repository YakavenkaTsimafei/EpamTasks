package by.epam.lab;

public class PriceDiscountPurchase extends AbstractPurchase {
    private Byn discount;


    public PriceDiscountPurchase(Byn discount) {
        this.discount = discount;
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
    public Byn getCost() {
        return getProduct().getPrice().sub(discount).mul(getNumber());
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }

}
