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

//    public Purchase(String[] fields) {
//        this(getValidPurchase(fields));
//    }
//
//    private static Purchase getValidPurchase(String[] fields) {
//        if (fields.length != Constants.THREE_NUMBER) {
//            throw new ArrayIndexOutOfBoundsException("Wrong args number");
//        }
//        return new Purchase(fields[0], new Byn(fields[1]), Integer.parseInt(fields[2]));
//    }
//
//    public Purchase(Purchase purchase) {
//        this(purchase.getName(), purchase.getPrice(), purchase.getNumber());
//    }
    public Purchase(String[] strings) {
        if (strings.length != 3) {
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
