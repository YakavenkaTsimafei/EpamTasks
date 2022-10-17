package by.epam.lab;

public class PriceDiscountPurchase extends Purchase {
    private final Byn discount;
    private static final String SEPARATOR = ";";

    public PriceDiscountPurchase() {
        super(null, new Byn(), 0);
        discount = new Byn();
    }

    public PriceDiscountPurchase(String name, Byn price, int number, Byn discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public PriceDiscountPurchase(String[] strings) {
        super(strings[0], new Byn(Integer.parseInt(strings[1])), Integer.parseInt(strings[2]));
        discount = new Byn(Integer.parseInt(strings[3]));
        if (discount.getValue() <= 0 || discount.getValue() >= 100) {
            throw new IllegalArgumentException();
        }
    }

    public Byn getDiscount() {
        return discount;
    }

    @Override
    public Byn getCost() {
        return new Byn(getPrice()).mul(getNumber()).sub(discount);
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + SEPARATOR + discount;
    }
}
