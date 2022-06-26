package by.epam.lab;

public class Byn implements Comparable<Byn> {
    private int costInKopecks;

    public Byn() {
    }

    public Byn(int costInKopecks) {
        this.costInKopecks = costInKopecks;
    }

    public Byn(Byn byn) {
        this.costInKopecks = byn.costInKopecks;
    }

    public Byn copy(Byn byn) {
        return new Byn(byn);
    }

    public Byn multiplicationWithADiscount(int number, double discount) {
        costInKopecks = (int) (costInKopecks * number * (100 - discount) / 100);
        return this;
    }

    public Byn multiplication(int number) {
        costInKopecks = costInKopecks * number;
        return this;
    }

    public Byn difference(Byn discount, int number) {
        costInKopecks = (costInKopecks - discount.costInKopecks) * number;
        return this;
    }

    @Override
    public int compareTo(Byn o) {
        if (o.costInKopecks > this.costInKopecks) return 1;
        if (o.costInKopecks == this.costInKopecks) return 0;
        else return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Byn byn = (Byn) o;
        return costInKopecks == byn.costInKopecks;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", costInKopecks / 100, costInKopecks % 100);
    }
}
