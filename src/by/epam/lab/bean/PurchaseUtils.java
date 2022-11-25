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

    public Purchase printPurchase() {
        return purchase;
    }

    public String printCost() {
        return COST + purchase.getCost();
    }

    public void printCostDiff(Purchase p) {
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

    public void printEqual(Purchase... purchases) {
        boolean isSameCost = false;
        Purchase foundPurchase = new Purchase();
        for (Purchase p : purchases) {
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
