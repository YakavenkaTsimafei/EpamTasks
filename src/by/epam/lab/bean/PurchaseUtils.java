package by.epam.lab.bean;

import by.epam.lab.Sale;

import static by.epam.lab.Constant.*;

public class PurchaseUtils<T extends Sale, N extends Number> {
    private final Purchase<T, N> purchase;

    public PurchaseUtils() {
        purchase = null;
    }

    public PurchaseUtils(Purchase<T, N> purchase) {
        this.purchase = purchase;
    }

    public Purchase<T, N> getPurchase() {
        return purchase;
    }

    public Purchase<T, N> printPurchase() {
        return purchase;
    }

    public String printCost() {
        return COST + purchase.getCost();
    }

    public void printCostDiff(Purchase<? extends Sale, ? extends Number> p) {
        String prefix = "";
        Byn costDiff = new Byn();
        int result = purchase.getCost().compareTo(p.getCost());
        if (result > 0) {
            prefix = POSITIVE;
            costDiff = purchase.getCost().sub(p.getCost());
        }
        if (result < 0) {
            prefix = NEGATIVE;
            costDiff = p.getCost().sub(purchase.getCost());
        }
        System.out.println(DIFF + prefix + costDiff + BYN);
    }

    public void printEqual(Purchase<? extends Sale, ? extends Number>... purchases) {
        boolean isSameCost = false;
        Purchase<? extends Sale, ? extends Number> foundPurchase = new Purchase<Sale, Number>();
        for (Purchase<? extends Sale, ? extends Number> p : purchases) {
            if (purchase.getCost().equals(p.getCost())) {
                isSameCost = true;
                foundPurchase = p;
                break;
            }
        }
        if (!isSameCost) {
            System.out.println("Purchase no found!");
        } else {
            System.out.println("Cost equal");
            System.out.println(foundPurchase);
        }
    }

}
