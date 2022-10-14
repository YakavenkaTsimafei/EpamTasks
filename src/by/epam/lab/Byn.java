package by.epam.lab;

import java.util.Scanner;


public class Byn implements Comparable<Byn> {
    private int value;

    public Byn() {
        this(0);
    }

    public int getValue() {
        return value;
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

    public int getRubs() {
        return this.value / 100;
    }

    public int getCoins() {
        return this.value % 100;
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
        return String.format("%d.%02d", getRubs(), getCoins());

    }
}

