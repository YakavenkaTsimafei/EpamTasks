package by.epam.lab;

public class Byn implements Comparable<Byn> {
    private int costInKopecks;

    public Byn() {
    }

    public Byn(int costInKopecks) {
        this.costInKopecks = costInKopecks;
    }

    public int multiplication(int c) {
        return costInKopecks * c;
    }

    public int difference(int c) {
        return costInKopecks - c;
    }

    @Override
    public int compareTo(Byn byn) {
        return byn.costInKopecks - this.costInKopecks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Byn byn = (Byn) o;
        return costInKopecks == byn.costInKopecks;
    }

    public static String toByn(int coins) {
        return String.format("%d.%02d", coins / 100, coins % 100);
    }

    @Override
    public String toString() {
        return toByn(costInKopecks);
    }


}
