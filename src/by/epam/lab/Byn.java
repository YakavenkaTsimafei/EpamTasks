package by.epam.lab;

import java.util.Scanner;

public class Byn {
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

    public int sb(Byn d) {
        return (value - d.value);
    }

    public Byn sub(Byn discount) {
        return new Byn(value - discount.value);
    }

    public Byn mul(double k) {
        return new Byn((int) Math.floor(value * k / 100) * 100);
    }


    @Override
    public String toString() {
        return String.format("%d.%02d", getRubs(), getCoins());

    }
}