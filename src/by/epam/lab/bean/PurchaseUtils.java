package by.epam.lab.bean;

import static by.epam.lab.Constant.*;

public class PurchaseUtils {
    private final Purchase purchase;

    public PurchaseUtils() {
        this(null);
    }

    public PurchaseUtils(Purchase purchase) {
        this.purchase = purchase;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void printPurchase() {
        System.out.println(purchase);
    }

    public void printCost() {

        System.out.println(COST + purchase.getCost());
    }

    public String printCostDiff(Purchase p) {
        int sign = purchase.getCost().compareTo(p.getCost());
        return (sign != 0 ? (sign > 0 ? POSITIVE : NEGATIVE) : "") + DIFF + new Byn(Math.abs(sign)) + BYN;

    }

    public void printEqual(Purchase[] p) {
        for (Purchase purchase : p) {
            if (this.purchase.getCost().equals(purchase.getCost())) {
                System.out.println("Cost equal");
            } else System.out.println("Cost not equal");

        }

    }


}
