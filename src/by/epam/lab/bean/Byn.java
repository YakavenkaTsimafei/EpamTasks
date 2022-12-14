package by.epam.lab.bean;

import by.epam.lab.RoundMethod;

import static by.epam.lab.Constant.FOR_OUTPUT;
import static by.epam.lab.Constant.HUNDRED;

public class Byn implements Comparable<Byn> {
    private final int value;

    public Byn() {
        this(0);
    }

    public Byn(Byn byn) {
        this(byn.value);
    }

    public Byn(int value) {
        this.value = value;
    }

    public Byn(String strKops) {
        this(Integer.parseInt(strKops));
    }

    public Byn(int rubs, int coins) {
        this(rubs * HUNDRED + coins);
    }

    public int getRubs() {
        return value / HUNDRED;
    }

    public int getCoins() {
        return value % HUNDRED;
    }

    public Byn mul(double k, RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(value * k, d));
    }

    public Byn sub(Byn byn) {
        return new Byn(value - byn.value);
    }

    public Byn div(int q) {
        return new Byn(value / q);
    }

    @Override
    public int compareTo(Byn o) {
        return value - o.value;
    }

    @Override
    public String toString() {
        return String.format(FOR_OUTPUT, getRubs(), getCoins());
    }

}