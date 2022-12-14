package by.epam.lab.bean;

import by.epam.lab.RoundMethod;
import by.epam.lab.Sale;

import static by.epam.lab.Constant.SEPARATOR;

public class Service implements Sale {
    private final String name;
    private final Byn totalCost;
    private final int numberOfUsers;

    public Service() {
        this(null, new Byn(), 0);
    }

    public Service(String name, Byn totalCost, int numberOfUsers) {
        this.name = name;
        this.totalCost = totalCost;
        this.numberOfUsers = numberOfUsers;
    }

    public String getName() {
        return name;
    }

    public Byn getPrice() {
        return totalCost.mul(1.0 / numberOfUsers, RoundMethod.CEIL, 0);
    }

    @Override
    public String toString() {
        return name + SEPARATOR + totalCost + SEPARATOR + numberOfUsers + SEPARATOR + getPrice();
    }
}
