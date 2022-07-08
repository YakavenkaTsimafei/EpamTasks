package by.epam.lab;

public class Byn implements Comparable<Byn> {
    private int value;

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

    public Byn copy(Byn byn) {
        return new Byn(byn);
    }

    public Byn mul(double k, Method.RoundMethod roundMethod, int d) {
        value = roundMethod.round(value * k, d);
        return this;
    }

    public Byn round(Method.RoundMethod roundMethod, int d) {
        value = roundMethod.round(value, d);
        return this;
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
        return o.value - this.value;
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
        return String.format("%d.%02d", value / 100, value % 100);
    }


}

