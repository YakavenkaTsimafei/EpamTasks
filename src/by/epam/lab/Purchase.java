package by.epam.lab;

public class Purchase implements Comparable<Purchase> {

    private final String name;
    private final Byn price;
    private final int number;

    public Purchase() {
        this(null, new Byn(), 0);
    }

    public Purchase(String name, Byn price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Purchase(String[] strings) {
        if (strings.length != Constants.FOUR_NUMBER) {
            throw new IllegalArgumentException();
        }
        name = strings[0];
        price = new Byn(Integer.parseInt(strings[1]));
        number = Integer.parseInt(strings[2]);
        if (name.equals("") || price.getValue() <= 0 || number <= 0) {
            throw new IllegalArgumentException();
        }
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
        return name + Constants.SEPARATOR + price + Constants.SEPARATOR + number;
    }

    @Override
    public String toString() {
        return fieldsToString() + Constants.SEPARATOR + getCost();
    }

    @Override
    public int compareTo(Purchase o) {
        return 0;
    }


}
