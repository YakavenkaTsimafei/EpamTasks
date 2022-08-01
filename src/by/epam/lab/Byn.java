package by.epam.lab;

import java.util.Scanner;

public class Byn implements Comparable<Byn> {
    private final int value;

    public Byn() {
        this(0);
    }

    public Byn(Scanner sc) {
        this.value = sc.nextInt();
    }

    public Byn(int value) {
        this.value = value;
    }

    public Byn(int rubs, int coins) {
        this(rubs * 100 + coins);
    }

    public Byn(Byn byn) {
        this(byn.value);
    }

    public int getValue() {
        return value;
    }

    public int getRubs() {
        return this.value / 100;
    }

    public int getCoins() {
        return this.value % 100;
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

    public Byn mul(double k, RoundMethod roundMethod, int d) {
       return new Byn(roundMethod.round(value * k, d));
    }

    @Override
    public int compareTo(Byn o) {
        return (this.value - o.value);
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
        return String.format("%d.%02d", getRubs(), getCoins());

    }
}