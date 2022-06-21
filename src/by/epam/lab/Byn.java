package by.epam.lab;

import static by.epam.lab.Utils.toByn;

public class Byn implements Comparable<Byn> {
    private int costInKopecks;

    public Byn() {
    }

    public Byn(int costInKopecks) {
        this.costInKopecks = costInKopecks;
    }

    @Override
    public int compareTo(Byn byn) {
        return byn.costInKopecks - this.costInKopecks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return costInKopecks == byn.costInKopecks;
    }


    @Override
    public String toString() {
        return toByn(costInKopecks);
    }


}
