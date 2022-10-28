package by.epam.lab.bean;

import by.epam.lab.exception.NonPositiveArgumentException;

import static by.epam.lab.Constants.*;

public class PriceDiscountPurchase extends Purchase {
    private final Byn discount;

    public PriceDiscountPurchase(String name, Byn price, int number, Byn discount) {
        super(name, price, number);
        if (discount.compareTo(new Byn(VALUE_ZERO)) <= VALUE_ZERO || discount.compareTo(new Byn(VALUE_HUNDRED)) >= VALUE_ZERO || discount.compareTo(price) > VALUE_ZERO) {
            throw new NonPositiveArgumentException(INVALID_VALUES_FOR_DISCOUNT);
        }
        this.discount = discount;

    }

    public PriceDiscountPurchase(String[] fields) {
        this(getValidPriceDiscountPurchase(fields));
    }

    public PriceDiscountPurchase(PriceDiscountPurchase purchase) {
        this(purchase.getName(), purchase.getPrice(), purchase.getNumber(), purchase.discount);
    }

    private static PriceDiscountPurchase getValidPriceDiscountPurchase(String[] fields) {
        if (fields.length != FOUR_NUMBER) {
            throw new ArrayIndexOutOfBoundsException(WRONGS_ARGS_NUMBER);
        }
        return new PriceDiscountPurchase(fields[VALUES_FOR_THE_NAME], new Byn(fields[VALUES_FOR_THE_PRICE]), Integer.parseInt(fields[VALUES_FOR_THE_NUMBER]), new Byn(fields[VALUES_FOR_THE_DISCOUNT]));
    }


    public Byn getDiscount() {
        return discount;
    }

    @Override
    public Byn getCost() {
        return getPrice().sub(discount).mul(getNumber());
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + SEPARATOR + discount;
    }
}
