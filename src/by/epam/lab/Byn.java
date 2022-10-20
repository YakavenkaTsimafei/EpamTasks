package by.epam.lab;


public class Byn implements Comparable<Byn> {
    private int value;

    public Byn() {
        this(0);
    }

    public Byn(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("wrong value for Byn: " + value);
        }
        this.value = value;

    }

    public Byn(int rubs, int coins) {
        this(getValidValue(rubs, coins));
    }

    public Byn(String strKops) {
        this(Integer.parseInt(strKops));
    }

    public Byn(Byn byn) {
        this(byn.value);
    }

    public int getRubs() {
        return this.value / 100;
    }

    public int getCoins() {
        return this.value % 100;
    }

    public int getValue() {
        return value;
    }

    public Byn add(Byn byn) {
        value += byn.value;
        return this;
    }

    public Byn mul(int number) {
        value *= number;
        return this;
    }

    public Byn sub(Byn discount) {
        value -= discount.value;
        return this;
    }

    private static int getValidValue(int rubs, int coins) {
        if (rubs < 0) {
            throw new IllegalArgumentException("Negative rubles");
        }
        if (coins < 0) {
            throw new IllegalArgumentException("Negative kopecks");
        }
        if (coins > 100) {
            throw new IllegalArgumentException("This is already rubles");
        } else {
            return 100 * rubs + coins;
        }
    }

    @Override
    public int compareTo(Byn o) {
        return this.value - o.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return value == byn.value;
    }

    @Override
    public String toString() {
        return String.format(Constants.FOR_OUTPUT, getRubs(), getCoins());

    }
}

