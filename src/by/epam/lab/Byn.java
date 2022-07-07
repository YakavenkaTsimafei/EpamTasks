package by.epam.lab;

public class Byn implements Comparable<Byn> {
    private int value;

    public Byn(int value) {
        this.value = value;
    }

    public Byn(int rubs, int coins) {
        this.value = rubs * 100 + coins;
    }

    public Byn(Byn byn) {
        this.value = byn.value;
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

    public Byn mul(double k, RoundMethod roundMethod, int d) {
        value = roundMethod.round(value * k, d);
        return this;
    }

    public Byn round(RoundMethod roundMethod, int d) {
        value = roundMethod.round(value, d);
        return this;
    }

    public Byn add(Byn byn) {
        value = value + byn.value;
        return this;
    }

    public Byn mul(int number) {
        value = value * number;
        return this;
    }

    public Byn sub(Byn discount) {
        value = value - discount.value;
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

    public enum RoundMethod {
        FLOOR {
            double roundFunction(double d) {
                return Math.floor(d);
            }
        },
        ROUND {
            double roundFunction(double d) {
                return Math.round(d);
            }
        },
        CEIL {
            double roundFunction(double d) {
                return Math.ceil(d);
            }
        };

        abstract double roundFunction(double value);

        private int round(double roundedValue, int d) {
            int[] tenPow = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
            return (int) roundFunction(roundedValue / tenPow[d]) * tenPow[d];
        }
    }
}

