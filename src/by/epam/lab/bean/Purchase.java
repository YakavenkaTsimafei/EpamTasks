package by.epam.lab.bean;

import by.epam.lab.exception.NonPositiveArgumentException;

import static by.epam.lab.Constants.*;

public class Purchase implements Comparable<Purchase> {

    private final String name;
    private final Byn price;
    private final int number;

    public Purchase(String name, Byn price, int number) {
        if (name.trim().isEmpty()) {
            throw new NonPositiveArgumentException(EMPTY_ARGUMENT);
        }
        if (price.compareTo(new Byn(VALUE_ZERO)) <= VALUE_ZERO) {
            throw new NonPositiveArgumentException(INVALID_VALUES_FOR_PRICE);
        }
        if (number <= VALUE_ZERO) {
            throw new NonPositiveArgumentException(INVALID_VALUES_FOR_NUMBER);
        }
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Purchase(String[] fields) {
        this(getValidPurchase(fields));
    }

    private static Purchase getValidPurchase(String[] fields) {
        if (fields.length != THREE_NUMBER) {
            throw new ArrayIndexOutOfBoundsException(WRONGS_ARGS_NUMBER);
        }
        return new Purchase(fields[VALUES_FOR_THE_NAME], new Byn(fields[VALUES_FOR_THE_PRICE]), Integer.parseInt(fields[VALUES_FOR_THE_NUMBER]));
    }

    public Purchase(Purchase purchase) {
        this(purchase.name, purchase.price, purchase.number);
    }


    public String getName() {
        return name;
    }

    public Byn getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public Byn getCost() {
        return new Byn(price).mul(number);
    }

    protected String fieldsToString() {
        return name + SEPARATOR + price + SEPARATOR + number;
    }

    @Override
    public String toString() {
        return fieldsToString() + SEPARATOR + getCost();
    }

    @Override
    public int compareTo(Purchase purchase) {
        return getCost().compareTo(purchase.getCost());
    }


}
