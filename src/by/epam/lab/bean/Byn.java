package by.epam.lab.bean;

import static by.epam.lab.Constants.*;

public class Byn implements Comparable<Byn> {
    private final int value;

    public Byn(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(WRONG_VALUE_FOR_BYN);
        }
        this.value = value;
    }

    public Byn() {
        this(0);
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
        return this.value / VALUE_HUNDRED;
    }

    public int getCoins() {
        return this.value % VALUE_HUNDRED;
    }

    public int getValue() {
        return value;
    }

    public Byn add(Byn byn) {
        return new Byn(value + byn.value);
    }

    public Byn mul(int number) {
        return new Byn(value * number);
    }

    public Byn sub(Byn discount) {
        return new Byn(value - discount.value);
    }

    private static int getValidValue(int rubs, int coins) {
        if (rubs < VALUE_ZERO) {
            throw new IllegalArgumentException(NEGATIVE_RUBLES);
        }
        if (coins < VALUE_ZERO) {
            throw new IllegalArgumentException(NEGATIVE_KOPECKS);
        }
        if (coins > VALUE_HUNDRED) {
            throw new IllegalArgumentException(THIS_IS_ALREADY_RUBLES);
        } else {
            return VALUE_HUNDRED * rubs + coins;
        }
    }

    @Override
    public int compareTo(Byn o) {
        return value - o.value;
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
        return String.format(FOR_OUTPUT, getRubs(), getCoins());

    }
}

